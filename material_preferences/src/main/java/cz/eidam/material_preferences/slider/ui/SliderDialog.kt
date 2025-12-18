package cz.eidam.material_preferences.slider.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cz.eidam.material_preferences.core.model.PreferenceDialogProperties
import cz.eidam.material_preferences.core.utils.roundToStep

@Composable
fun SliderDialog(
    onDismissRequest: () -> Unit,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    step: Float,
    properties: PreferenceDialogProperties,
    transform: (Float) -> String,
    modifier: Modifier = Modifier,
) {
    var internal by rememberSaveable { mutableFloatStateOf(value) }

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
            Column(
            ) {
                SliderTextField(
                    value = internal,
                    onValueChange = {
                        internal = it.roundToStep(step).coerceIn(valueRange)
                    },
                    valueRange = valueRange,
                    transform = transform
                )

                Slider(
                    value = internal,
                    valueRange = valueRange,
                    onValueChange = { value ->
                        val stepped = value.roundToStep(step).coerceIn(valueRange)
                        internal = stepped
                    },
                )

            }
        }
    )
}