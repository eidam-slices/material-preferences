package cz.eidam.material_preferences.rangeslider.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import cz.eidam.material_preferences.generic.ui.PreferenceRow
import cz.eidam.material_preferences.core.model.PreferenceDialogProperties
import cz.eidam.material_preferences.core.utils.coerceIn

@Composable
fun PreferenceRangeSlider(
    title: String,
    description: String? = null,
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    step: Float,
    properties: PreferenceDialogProperties = PreferenceDialogProperties.default(title),
    transform: (ClosedFloatingPointRange<Float>) -> String,
) {

    var dialogVisible by rememberSaveable { mutableStateOf(false) }


    PreferenceRow(
        title = title,
        description = description,
        onClick = { dialogVisible = true },
    ) {
        Text(
            text = transform(value),
            style = MaterialTheme.typography.titleMedium
        )
    }

    if (dialogVisible) {
        RangeSliderDialog(
            onDismissRequest = { dialogVisible = false },
            value = value.coerceIn(valueRange),
            onValueChange = onValueChange,
            valueRange = valueRange,
            step = step,
            properties = properties,
            transform = transform,
        )
    }


}
