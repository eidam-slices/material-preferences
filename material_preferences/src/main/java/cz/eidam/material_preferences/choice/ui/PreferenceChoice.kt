package cz.eidam.material_preferences.choice.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import cz.eidam.material_preferences.core.model.ChoiceItem
import cz.eidam.material_preferences.core.model.PreferenceDialogProperties
import cz.eidam.material_preferences.generic.ui.PreferenceRow

@Composable
fun PreferenceChoice(
    title: String,
    description: String? = null,
    defaultValue: String,
    value: String,
    onValueChange: (String) -> Unit,
    choices: List<ChoiceItem<String>>,
    dialogProperties: PreferenceDialogProperties = PreferenceDialogProperties.default(title)
) {
    require(choices.isNotEmpty()) { "Choices list must not be empty." }
    require(defaultValue in choices.map { it.value }) {
        "Default value must be one of the choice values."
    }

    var dialogVisible by rememberSaveable { mutableStateOf(false) }

    val choiceMap = remember(choices) {
        choices.associateBy { it.value }
    }

    PreferenceRow(
        title = title,
        description = description,
        onClick = { dialogVisible = true }
    ) {
        Text(
            text = choiceMap[value]?.label ?: "",
            style = MaterialTheme.typography.titleMedium
        )
    }

    if (dialogVisible) {
        ChoicesDialog(
            onDismissRequest = { dialogVisible = false },
            value = value,
            onValueChange = onValueChange,
            choices = choices,
            properties = dialogProperties,
        )
    }
}