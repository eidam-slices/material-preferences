package cz.eidam.material_preferences.textfield.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.model.TextFieldDialogProperties
import cz.eidam.material_preferences.core.utils.getStringState
import cz.eidam.material_preferences.core.utils.setString
import kotlinx.coroutines.launch

@Composable
fun DataStorePreferenceTextField(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: String,
    dialogProperties: TextFieldDialogProperties = TextFieldDialogProperties.default(title),
    dataStore: DataStore<Preferences>,
) {
    val value by dataStore.getStringState(key, defaultValue)

    val scope = rememberCoroutineScope()
    PreferenceTextField(
        title = title,
        description = description,
        value = value,
        onValueChange = { updated ->
            scope.launch {
                dataStore.setString(key, updated)
            }
        },
        dialogProperties = dialogProperties,
    )

}