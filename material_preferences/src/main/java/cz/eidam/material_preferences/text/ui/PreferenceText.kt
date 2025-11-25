package cz.eidam.material_preferences.text.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import cz.eidam.material_preferences.core.model.TextFieldDialogProperties
import cz.eidam.material_preferences.generic.ui.PreferenceRow

@Composable
fun PreferenceText(
    title: String,
    description: String? = null,
    value: String,
    onValueChange: (String) -> Unit,
    dialogProperties: TextFieldDialogProperties = TextFieldDialogProperties.default(title)
) {

    var dialogVisible by rememberSaveable { mutableStateOf(false) }

    PreferenceRow(
        title = title,
        description = description,
        onClick = { dialogVisible = true },
        widget = {
            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium
            )
        }
    )


    if (dialogVisible) {
        TextDialog(
            onDismissRequest = { dialogVisible = false },
            title = title,
            value = value,
            onValueChange = onValueChange,
            properties = dialogProperties
        )

    }
}