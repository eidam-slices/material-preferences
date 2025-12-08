package cz.eidam.material_preferences.choice.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.utils.dataStore
import cz.eidam.material_preferences.core.utils.getStringState
import cz.eidam.material_preferences.core.utils.setString
import kotlinx.coroutines.launch


@Composable
fun DataStorePreferenceChoice(
    key: String,
    title: String,
    description: String? = null,
    entries: List<String>,
    entryValues: List<String>,
    defaultValue: String,
    dataStore: DataStore<Preferences> = LocalContext.current.dataStore,
) {
    val value by dataStore.getStringState(key, defaultValue)

    val scope = rememberCoroutineScope()
    PreferenceChoice(
        title = title,
        description = description,
        defaultValue = defaultValue,
        entries = entries,
        entryValues = entryValues,
        value = value,
        onValueChange = { updated ->
            scope.launch {
                dataStore.setString(key, updated)
            }
        }
    )

}