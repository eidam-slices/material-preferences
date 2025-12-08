package cz.eidam.material_preferences.multichoice.ui

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cz.eidam.material_preferences.core.model.PreferenceDialogProperties

@Composable
fun MultiChoiceDialog(
    onDismissRequest: () -> Unit,
    values: Set<String>,
    onValueChange: (Set<String>) -> Unit,
    pairs: List<Pair<String, String>>,
    properties: PreferenceDialogProperties,
    modifier: Modifier = Modifier,
) {
    var internal by rememberSaveable { mutableStateOf(values) }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier.width(IntrinsicSize.Max), title = { Text(properties.title) },
        text = {
            Column {
                pairs.forEach { (entry, entryValue) ->

                    val checked = internal.contains(entryValue)


                    val interactionSource = remember { MutableInteractionSource() }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                indication = null,
                                interactionSource = interactionSource,
                                onClick = {
                                    internal = if (checked) internal - entryValue
                                    else internal + entryValue
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            interactionSource = interactionSource,
                            checked = checked,
                            onCheckedChange = {
                                internal = if (checked) internal - entryValue
                                else internal + entryValue
                            }
                        )

                        Text(
                            text = entry,
                            style = MaterialTheme.typography.bodyLarge
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

@Preview
@Composable
private fun Preview() {

    val entries = listOf("Mrdka 1", "Mrdka 2", "Mrdka 3")
    val entryValues = listOf("val1", "val2", "val3")

    var values by rememberSaveable { mutableStateOf(setOf("val1")) }

    MultiChoiceDialog(
        onDismissRequest = {},
        values = values,
        onValueChange = {
            values = it
        },
        pairs = entries.zip(entryValues),
        properties = PreferenceDialogProperties(
            title = "Hovno nadpis",
            confirmText = stringResource(R.string.ok),
            cancelText = stringResource(R.string.cancel)
        )
    )


}