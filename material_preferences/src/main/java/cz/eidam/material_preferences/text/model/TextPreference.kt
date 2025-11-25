package cz.eidam.material_preferences.text.model

import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.generic.model.Preference

sealed class TextPreference: Preference() {

    abstract override val defaultValue: String

    // TODO: add dialog properties property
    data class Modal(
        override val key: String,
        override val title: Text,
        override val description: Text?,
        override val defaultValue: String,
    ): TextPreference()

    data class Inline(
        override val key: String,
        override val title: Text,
        override val description: Text?,
        override val defaultValue: String,
    ): TextPreference()
}
