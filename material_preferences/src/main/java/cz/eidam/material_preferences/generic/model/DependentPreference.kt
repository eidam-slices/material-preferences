package cz.eidam.material_preferences.generic.model

import cz.eidam.material_preferences.core.dsl.PreferenceScope

data class DependentPreference<T>(
    val dependencyKey: String,
    val defaultValue: T,
    val serialize: (T) -> String,
    val deserialize: (String) -> T,
    val content: PreferenceScope.(T) -> Unit
): PreferenceRow, PreferenceScope()