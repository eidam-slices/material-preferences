package cz.eidam.material_preferences.text.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cz.eidam.material_preferences.core.model.TextFieldDialogProperties

@Composable
fun TextDialog(
    onDismissRequest: () -> Unit,
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    properties: TextFieldDialogProperties,
    modifier: Modifier = Modifier,
) {

    var internal by rememberSaveable { mutableStateOf(value) }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = { Text(title) },
        confirmButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                    onValueChange(internal)
                }
            ) { Text("Confirm") }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text("Cancel")
            }
        },
        text = {
            OutlinedTextField(
                value = internal,
                onValueChange = { internal = it },
                label = properties.label?.let { { Text(it) } },
                placeholder = properties.placeholder?.let { { Text(it) } },
            )
        }
    )
}