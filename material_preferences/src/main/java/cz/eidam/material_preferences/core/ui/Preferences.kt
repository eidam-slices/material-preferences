package cz.eidam.material_preferences.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.dsl.PreferenceScope
import cz.eidam.material_preferences.data.dataStore

@Composable
fun Preferences(
    dataStore: DataStore<Preferences> = LocalContext.current.dataStore,
    content: PreferenceScope.() -> Unit
) {
    val scope = PreferenceScope().apply(content)
    Column {
        scope.all.forEach { preference ->
            DrawPreferenceRow(preference, dataStore)
        }
    }
}