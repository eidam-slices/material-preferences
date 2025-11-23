package cz.eidam.material_preferences.multichoice.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import cz.eidam.material_preferences.core.model.PreferenceDialogProperties
import cz.eidam.material_preferences.generic.ui.PreferenceRow

@Composable
fun PreferenceMultiChoice(
    title: String,
    description: String? = null,
    values: Set<String>,
    onValueChange: (Set<String>) -> Unit,
    entries: List<String>,
    entryValues: List<String>,
    dialogProperties: PreferenceDialogProperties = PreferenceDialogProperties.default(title)
) {

    val pairs = entries.zip(entryValues)

    var dialogVisible by rememberSaveable { mutableStateOf(false) }

    PreferenceRow(
        title = title,
        description = description,
        onClick = { dialogVisible = true }
    ) {
        Text(
            text = pairs
                .filter { it.second in values }
                .joinToString(", ") { it.first }
        )
    }

    if (dialogVisible) {
        MultiChoiceDialog(
            onDismissRequest = { dialogVisible = false },
            values = values,
            onValueChange = onValueChange,
            pairs = pairs,
            properties = dialogProperties,
        )
    }
}