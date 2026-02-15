package cz.eidam.material_preferences.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.dsl.PreferenceScope

@Composable
fun Preferences(
    modifier: Modifier = Modifier,
    dataStore: DataStore<Preferences>,
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