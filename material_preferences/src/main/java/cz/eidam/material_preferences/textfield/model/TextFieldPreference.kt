package cz.eidam.material_preferences.textfield.model

import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.generic.model.Preference

sealed class TextFieldPreference: Preference() {

    abstract override val defaultValue: String

    // TODO: add dialog properties property
    data class Modal(
        override val key: String,
        override val title: Text,
        override val description: Text?,
        override val defaultValue: String,
    ): TextFieldPreference()

    data class Inline(
        override val key: String,
        override val title: Text,
        override val description: Text?,
        override val defaultValue: String,
    ): TextFieldPreference()
}
