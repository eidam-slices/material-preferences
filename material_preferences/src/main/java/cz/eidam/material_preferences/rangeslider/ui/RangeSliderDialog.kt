package cz.eidam.material_preferences.rangeslider.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cz.eidam.material_preferences.core.model.PreferenceDialogProperties
import cz.eidam.material_preferences.core.utils.coerceIn
import cz.eidam.material_preferences.core.utils.roundToStep

@Composable
fun RangeSliderDialog(
    onDismissRequest: () -> Unit,
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    step: Float,
    transform: (ClosedFloatingPointRange<Float>) -> String,
    properties: PreferenceDialogProperties,
    modifier: Modifier = Modifier,
) {
    var internal by rememberSaveable { mutableStateOf(value) }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = { Text(properties.title) },
        confirmButton = {
            TextButton(
                onClick = {
                    onValueChange(internal)
                    onDismissRequest()
                }
            ) {
                Text(properties.confirmText)
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismissRequest
            ) {
                Text(properties.cancelText)
            }
        },
        text = {
            Column {
                // ? TODO: extract this to composable ?
                BasicText(
                    text = transform(internal),
                )
                RangeSlider(
                    value = internal,
                    onValueChange = { value ->
                        val stepped = value.roundToStep(step).coerceIn(valueRange)
                        internal = stepped
                    },
                    valueRange = valueRange,
                )
            }
        }
    )
}