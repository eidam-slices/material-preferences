package cz.eidam.material_preferences.multichoice.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import cz.eidam.material_preferences.core.model.ChoiceItem
import cz.eidam.material_preferences.core.model.PreferenceDialogProperties
import cz.eidam.material_preferences.generic.ui.PreferenceRow

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PreferenceMultiChoice(
    title: String,
    description: String? = null,
    values: Set<String>,
    onValueChange: (Set<String>) -> Unit,
    choices: List<ChoiceItem<String>>,
    tooltipEnabled: Boolean = true,
    dialogProperties: PreferenceDialogProperties = PreferenceDialogProperties.default(title),
    valueDisplayFormatter: (List<String>) -> String,
) {

    var dialogVisible by rememberSaveable { mutableStateOf(false) }

    PreferenceRow(
        title = title,
        description = description,
        onClick = { dialogVisible = true }
    ) {
        val selected = choices.map { it.value }.filter { it in values }

        if (tooltipEnabled) {
            PreferenceTooltip(
                tooltip = {
                    Column {
                        selected.forEach { selectedEntry ->
                            Text(
                                text = selectedEntry,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    }
                }
            ) {
                // TODO: extract this text composable somewhere, because it's used on many places
                Text(
                    text = valueDisplayFormatter(selected),
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        } else {
            Text(
                text = valueDisplayFormatter(selected),
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }

    if (dialogVisible) {
        MultiChoiceDialog(
            onDismissRequest = { dialogVisible = false },
            values = values,
            onValueChange = onValueChange,
            choices = choices,
            properties = dialogProperties,
        )
    }
}