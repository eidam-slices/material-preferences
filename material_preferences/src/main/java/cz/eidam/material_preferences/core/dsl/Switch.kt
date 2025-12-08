package cz.eidam.material_preferences.core.dsl

import androidx.annotation.StringRes
import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.switch.model.SwitchPreference

fun PreferenceScope.switch(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: Boolean,
) = add {
    SwitchPreference(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue
    )
}

fun PreferenceScope.switch(
    key: String,
    @StringRes
    title: Int,
    @StringRes
    description: Int? = null,
    defaultValue: Boolean,
) = add {
    SwitchPreference(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue,
    )
}