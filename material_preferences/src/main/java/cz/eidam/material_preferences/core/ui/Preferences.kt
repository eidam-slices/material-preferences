package cz.eidam.material_preferences.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.dsl.PreferenceScope
import cz.eidam.material_preferences.core.utils.dataStore

@Composable
fun Preferences(
    modifier: Modifier = Modifier,
    dataStore: DataStore<Preferences> = LocalContext.current.dataStore,
    content: @Composable PreferenceScope.() -> Unit
) {
    val scope = PreferenceScope()
    scope.clear()
    scope.content()

    Column(modifier) {
        scope.all.forEach { preference ->
            DrawPreferenceRow(preference, dataStore)
        }
    }
}