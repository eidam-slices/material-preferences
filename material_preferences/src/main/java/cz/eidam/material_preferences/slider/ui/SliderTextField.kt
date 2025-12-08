package cz.eidam.material_preferences.slider.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.rememberTextMeasurer
import java.text.NumberFormat
import java.util.Locale

@Composable
fun SliderTextField(
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    modifier: Modifier = Modifier,
    transform: (Float) -> String,
) {

    // keyboard and focus controllers
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusController = LocalFocusManager.current

    // number format
    val locale = Locale.getDefault()
    val numberFormat by remember { derivedStateOf { NumberFormat.getNumberInstance(locale) } }

    // max text length based on value range
    val maxTextLength by remember {
        derivedStateOf {
            transform(valueRange.endInclusive).length
        }
    }

    // formatting lock
    var formattingEnabled by remember { mutableStateOf(true) }

    val measurer = rememberTextMeasurer()

    var text by remember { mutableStateOf(transform(value)) }

    LaunchedEffect(value) {
        if (formattingEnabled) {
            text = transform(value)
        } else {
            formattingEnabled = true
        }
    }

    val fieldWidth = with(LocalDensity.current) {
        measurer.measure(text).size.width.toDp()
    }

    Row {
        BasicTextField(
            modifier = modifier
                .width(fieldWidth)
                .animateContentSize(),
            maxLines = 1,
            value = text,
            onValueChange = {
                if (it.length > maxTextLength) return@BasicTextField
                text = it

                val parsed = it.toFloatOrNull(numberFormat)
                parsed?.coerceIn(valueRange)?.let { coersed ->
                    formattingEnabled = false
                    onValueChange(coersed)
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done,
                autoCorrectEnabled = false,
            ),
            keyboardActions = KeyboardActions {
                text.toFloatOrNull(numberFormat)?.let {
                    focusController.clearFocus()
                    keyboardController?.hide()
                }
                text = transform(value)
                formattingEnabled = true
            },
        )
    }


}

private fun String.toFloatOrNull(numberFormat: NumberFormat): Float? {
    return try {
        numberFormat.parse(this)?.toFloat()
    } catch (_: Exception) {
        null
    }
}