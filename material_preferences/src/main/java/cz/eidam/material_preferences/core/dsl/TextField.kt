package cz.eidam.material_preferences.core.dsl

import cz.eidam.material_preferences.textfield.model.TextFieldPreference

// String Overload
fun PreferenceScope.textField(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: String,
) = add {
    TextFieldPreference.Modal(
        key = key,
        title = title,
        description = description,
        defaultValue = defaultValue
    )
}

// String / Inline Overload
fun PreferenceScope.inlineTextField(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: String,
) = add {
    TextFieldPreference.Inline(
        key = key,
        title = title,
        description = description,
        defaultValue = defaultValue
    )
}