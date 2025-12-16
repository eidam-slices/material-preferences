package cz.eidam.material_preferences.generic.model

import androidx.compose.runtime.Composable
import cz.eidam.material_preferences.core.dsl.PreferenceScope

data class DependentPreference<T>(
    val dependencyKey: String,
    val defaultValue: T,
    val serialize: (T) -> String,
    val deserialize: (String) -> T,
    val content: @Composable PreferenceScope.(T) -> Unit
): PreferenceRow