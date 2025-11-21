package cz.eidam.material_preferences.slider.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import cz.eidam.material_preferences.generic.ui.PreferenceRow

@Composable
fun PreferenceSlider(
    title: String,
    description: String? = null,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    step: Float,
    transform: (Float) -> String,
) {

    var dialogVisible by rememberSaveable { mutableStateOf(false) }


    PreferenceRow(
        title = title,
        description = description,
        onClick = {
            dialogVisible = true
        },
        widget = {
            Text(
                text = transform(value),
                style = MaterialTheme.typography.titleMedium
            )
        }
    )

    if (dialogVisible) {
        SliderDialog(
            onDismissRequest = { dialogVisible = false },
            label = title,
            value = value,
            onValueChange = onValueChange,
            valueRange = valueRange,
            step = step,
            transform = transform,
        )
    }

}