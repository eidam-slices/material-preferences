package cz.eidam.material_preferences.core.dsl

import cz.eidam.material_preferences.switch.model.SwitchPreference

fun PreferenceScope.switch(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: Boolean,
) = add {
    SwitchPreference(
        key = key,
        title = title,
        description = description,
        defaultValue = defaultValue
    )
}