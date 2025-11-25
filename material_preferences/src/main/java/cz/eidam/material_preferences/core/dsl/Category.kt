package cz.eidam.material_preferences.core.dsl

import androidx.annotation.StringRes
import cz.eidam.material_preferences.category.model.PreferenceCategory
import cz.eidam.material_preferences.core.model.Text

// No title Overload
fun PreferenceScope.category(
    content: PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = null,
        collapsible = false,
    ).apply(content)
}

// String title Overload
fun PreferenceScope.category(
    title: String? = null,
    content: PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = Text(title),
        collapsible = false,
    ).apply(content)
}

// String Resource title Overload
fun PreferenceScope.category(
    @StringRes title: Int? = null,
    content: PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = Text(title),
        collapsible = false,
    ).apply(content)
}

// Collapsible / String title Overload
fun PreferenceScope.collapsibleCategory(
    title: String,
    content: PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = Text(title),
        collapsible = true,
    ).apply(content)
}

// Collapsible / String Resource title Overload
fun PreferenceScope.collapsibleCategory(
    @StringRes title: Int,
    content: PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = Text(title),
        collapsible = true,
    ).apply(content)
}