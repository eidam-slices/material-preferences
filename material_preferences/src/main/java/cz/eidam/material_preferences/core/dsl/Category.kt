package cz.eidam.material_preferences.core.dsl

import androidx.compose.runtime.Composable
import cz.eidam.material_preferences.category.model.PreferenceCategory

// No title Overload
fun PreferenceScope.category(
    content: @Composable PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = null,
        collapsible = false,
        content = content,
    )
}

// String title Overload
fun PreferenceScope.category(
    title: String,
    content: @Composable PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = title,
        collapsible = false,
        content = content,
    )
}

// Collapsible / String title Overload
fun PreferenceScope.collapsibleCategory(
    title: String,
    content: @Composable PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = title,
        collapsible = true,
        content = content,
    )
}