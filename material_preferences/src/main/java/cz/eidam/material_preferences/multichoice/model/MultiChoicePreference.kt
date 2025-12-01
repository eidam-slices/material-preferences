package cz.eidam.material_preferences.multichoice.model

import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.generic.model.Preference

internal sealed class MultiChoicePreference: Preference() {
    abstract override val defaultValue: Set<String>
    abstract val entries: List<Text>
    abstract val entryValues: List<String>

    data class Custom(
        override val key: String,
        override val title: Text,
        override val description: Text?,
        override val defaultValue: Set<String>,
        override val entries: List<Text>,
        override val entryValues: List<String>,
        val tooltipEnabled: Boolean,
        val valueFormatter: (List<String>) -> String,
    ): MultiChoicePreference()

    data class Default(
        override val key: String,
        override val title: Text,
        override val description: Text?,
        override val defaultValue: Set<String>,
        override val entries: List<Text>,
        override val entryValues: List<String>,
    ): MultiChoicePreference()
}