package cz.eidam.material_preferences.choice.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cz.eidam.material_preferences.core.model.PreferenceDialogProperties


@Composable
fun ChoicesDialog(
    onDismissRequest: () -> Unit,
    value: String,
    onValueChange: (String) -> Unit,
    entries: List<String>,
    entryValues: List<String>,
    properties: PreferenceDialogProperties,

    modifier: Modifier = Modifier,
) {
    var internal by rememberSaveable { mutableStateOf(value) }
    val options = entries.zip(entryValues)

    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = { Text(properties.title) },
        text = {
            Column {
                options.forEach { (entry, entryValue) ->
                    val selected = entryValue == internal

                    val interactionSource = remember { MutableInteractionSource() }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null,
                                onClick = { internal = entryValue }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selected,
                            onClick = { internal = entryValue },
                            interactionSource = interactionSource,
                        )
                        Text(
                            text = entry,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        },
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
        }
    )
}