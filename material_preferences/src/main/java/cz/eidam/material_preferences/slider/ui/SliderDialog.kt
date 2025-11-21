package cz.eidam.material_preferences.slider.ui

import android.R
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
import androidx.compose.ui.res.stringResource
import cz.eidam.material_preferences.core.utils.roundToStep

@Composable
fun SliderDialog(
    onDismissRequest: () -> Unit,
    label: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    step: Float,
    modifier: Modifier = Modifier,
    transform: (Float) -> String,
) {
    var internal by rememberSaveable { mutableFloatStateOf(value) }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = { Text(label) },
        confirmButton = {
            TextButton(
                onClick = {
                    onValueChange(internal)
                    onDismissRequest()
                }
            ) {
                Text(stringResource(R.string.ok))
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismissRequest
            ) {
                Text(stringResource(R.string.cancel))
            }
        },
        text = {
            Column(
            ) {
                SliderTextField(
                    value = internal,
                    onValueChange = {
                        internal = it
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