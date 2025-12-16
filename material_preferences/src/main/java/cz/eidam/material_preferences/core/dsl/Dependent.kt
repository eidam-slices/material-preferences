package cz.eidam.material_preferences.core.dsl

import androidx.compose.runtime.Composable
import cz.eidam.material_preferences.generic.model.DependentPreference

fun <T> PreferenceScope.dependent(
    dependencyKey: String,
    defaultValue: T,
    serialize: (T) -> String,
    deserialize: (String) -> T,
    content: @Composable PreferenceScope.(T) -> Unit,
) = add {
    DependentPreference(
        dependencyKey = dependencyKey,
        defaultValue = defaultValue,
        serialize = serialize,
        deserialize = deserialize,
        content = content,
    )
}