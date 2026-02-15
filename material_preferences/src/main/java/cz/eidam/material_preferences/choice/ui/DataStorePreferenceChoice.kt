package cz.eidam.material_preferences.choice.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.model.ChoiceItem
import cz.eidam.material_preferences.core.utils.getStringState
import cz.eidam.material_preferences.core.utils.setString
import kotlinx.coroutines.launch


@Composable
fun DataStorePreferenceChoice(
    key: String,
    title: String,
    description: String? = null,
    choices: List<ChoiceItem<String>>,
    defaultValue: String,
    dataStore: DataStore<Preferences>,
) {
    val value by dataStore.getStringState(key, defaultValue)

    val scope = rememberCoroutineScope()
    PreferenceChoice(
        title = title,
        description = description,
        defaultValue = defaultValue,
        choices = choices,
        value = value,
        onValueChange = { updated ->
            scope.launch {
                dataStore.setString(key, updated)
            }
        }
    )

}