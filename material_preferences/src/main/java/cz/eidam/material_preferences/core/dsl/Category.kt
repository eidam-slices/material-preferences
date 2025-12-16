package cz.eidam.material_preferences.core.dsl

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import cz.eidam.material_preferences.category.model.PreferenceCategory
import cz.eidam.material_preferences.core.model.Text

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
    title: String? = null,
    content: @Composable PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = Text(title),
        collapsible = false,
        content = content,
    )
}

// String Resource title Overload
fun PreferenceScope.category(
    @StringRes title: Int? = null,
    content: @Composable PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = Text(title),
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
        title = Text(title),
        collapsible = true,
        content = content,
    )
}

// Collapsible / String Resource title Overload
fun PreferenceScope.collapsibleCategory(
    @StringRes title: Int,
    content: @Composable PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = Text(title),
        collapsible = true,
        content = content,
    )
}