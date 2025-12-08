package cz.eidam.material_preferences.choice.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import cz.eidam.material_preferences.core.model.PreferenceDialogProperties
import cz.eidam.material_preferences.generic.ui.PreferenceRow

@Composable
fun PreferenceChoice(
    title: String,
    description: String? = null,
    defaultValue: String,
    value: String,
    onValueChange: (String) -> Unit,
    entries: List<String>,
    entryValues: List<String>,

    dialogProperties: PreferenceDialogProperties = PreferenceDialogProperties.default(title)
) {

    var dialogVisible by rememberSaveable { mutableStateOf(false) }

    PreferenceRow(
        title = title,
        description = description,
        onClick = { dialogVisible = true }
    ) {
        Text(
            text = entries.getOrElse(entryValues.indexOf(value)) { defaultValue },
            style = MaterialTheme.typography.titleMedium
        )
    }

    if (dialogVisible) {
        ChoicesDialog(
            value = value,
            onValueChange = onValueChange,
            entries = entries,
            entryValues = entryValues,
            onDismissRequest = { dialogVisible = false },
            properties = dialogProperties,
        )
    }
}