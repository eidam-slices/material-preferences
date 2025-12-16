package cz.eidam.material_preferences.textfield.model

import cz.eidam.material_preferences.generic.model.Preference

sealed class TextFieldPreference: Preference() {

    abstract override val defaultValue: String

    // TODO: add dialog properties property
    data class Modal(
        override val key: String,
        override val title: String,
        override val description: String?,
        override val defaultValue: String,
    ): TextFieldPreference()

    data class Inline(
        override val key: String,
        override val title: String,
        override val description: String?,
        override val defaultValue: String,
    ): TextFieldPreference()
}
