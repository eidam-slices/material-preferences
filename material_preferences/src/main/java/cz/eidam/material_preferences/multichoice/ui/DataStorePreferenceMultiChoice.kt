package cz.eidam.material_preferences.multichoice.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.model.ChoiceItem
import cz.eidam.material_preferences.core.utils.dataStore
import cz.eidam.material_preferences.core.utils.getStringSetState
import cz.eidam.material_preferences.core.utils.setStringSet
import kotlinx.coroutines.launch

@Composable
fun DataStorePreferenceMultiChoice(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: Set<String>,
    choices: List<ChoiceItem<String>>,
    tooltipEnabled: Boolean = true,
    valueDisplayFormatter: (List<String>) -> String = MultiChoicePreferenceDefaults.formatter(),
    dataStore: DataStore<Preferences> = LocalContext.current.dataStore,
) {
    val values by dataStore.getStringSetState(key, defaultValue)

    val scope = rememberCoroutineScope()
    PreferenceMultiChoice(
        title = title,
        description = description,
        choices = choices,
        values = values,
        onValueChange = { updated ->
            scope.launch {
                dataStore.setStringSet(key, updated)
            }
        },
        tooltipEnabled = tooltipEnabled,
        valueDisplayFormatter = valueDisplayFormatter,
    )

}