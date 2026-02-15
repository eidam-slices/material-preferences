package cz.eidam.material_preferences.textfield.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.utils.getStringState
import cz.eidam.material_preferences.core.utils.setString
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val DEBOUNCE_DELAY_MS = 200L

@Composable
fun DataStorePreferenceTextFieldInline(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: String,
    // TODO: remove default parameter:
    dataStore: DataStore<Preferences>,
) {
    val value by dataStore.getStringState(key, defaultValue)

    var internal by remember { mutableStateOf(defaultValue) }

    LaunchedEffect(value) {
        if (value != internal) {
            internal = value
        }
    }

    val scope = rememberCoroutineScope()
    var job by remember { mutableStateOf<Job?>(null) }
    PreferenceTextFieldInline(
        title = title,
        description = description,
        value = internal,
        onValueChange = { updated ->
            internal = updated

            job?.cancel()
            job = scope.launch {
                delay(DEBOUNCE_DELAY_MS)
                dataStore.setString(key, updated)
            }
        }
    )

}