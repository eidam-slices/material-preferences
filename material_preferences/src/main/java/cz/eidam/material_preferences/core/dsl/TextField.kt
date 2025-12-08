package cz.eidam.material_preferences.core.dsl

import androidx.annotation.StringRes
import cz.eidam.material_preferences.core.model.Text
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
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue
    )
}

// String Resource Overload
fun PreferenceScope.textField(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int? = null,
    defaultValue: String,
) = add {
    TextFieldPreference.Modal(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue,
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
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue
    )
}

// String Resource / Inline Overload
fun PreferenceScope.inlineTextField(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int? = null,
    defaultValue: String,
) = add {
    TextFieldPreference.Inline(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue,
    )
}