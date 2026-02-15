package cz.eidam.material_preferences.switch.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.utils.getBooleanState
import cz.eidam.material_preferences.core.utils.setBoolean
import kotlinx.coroutines.launch

@Composable
fun DataStorePreferenceSwitch(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: Boolean,
    dataStore: DataStore<Preferences>,
) {
    val value by dataStore.getBooleanState(key, defaultValue)

    val scope = rememberCoroutineScope()
    PreferenceSwitch(
        title = title,
        description = description,

        checked = value,
        onCheckedChange = { updated ->
            scope.launch {
                dataStore.setBoolean(key, updated)
            }
        }
    )
}