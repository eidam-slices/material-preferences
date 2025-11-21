package cz.eidam.material_preferences.core.dsl

import androidx.annotation.StringRes
import cz.eidam.material_preferences.category.model.PreferenceCategory
import cz.eidam.material_preferences.core.model.Text

fun PreferenceScope.category(
    content: PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = null,
        collapsible = false,
    ).apply(content)
}

fun PreferenceScope.category(
    title: String? = null,
    content: PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = Text(title),
        collapsible = false,
    ).apply(content)
}

fun PreferenceScope.category(
    @StringRes title: Int? = null,
    content: PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = Text(title),
        collapsible = false,
    ).apply(content)
}

fun PreferenceScope.collapsibleCategory(
    @StringRes title: Int? = null,
    content: PreferenceScope.() -> Unit
) = add {
    PreferenceCategory(
        title = Text(title),
        collapsible = false,
    ).apply(content)
}