package cz.eidam.material_preferences.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cz.eidam.material_preferences.core.dsl.PreferenceScope
import cz.eidam.material_preferences.utils.Preferences

@Composable
fun Preferences(
    modifier: Modifier = Modifier,
    preferences: Preferences,
    content: @Composable PreferenceScope.() -> Unit
) {
    cz.eidam.material_preferences.core.ui.Preferences(
        modifier = modifier,
        dataStore = preferences.dataStore,
        content = content
    )
}