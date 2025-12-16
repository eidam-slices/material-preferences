package cz.eidam.material_preferences.multichoice.model

import cz.eidam.material_preferences.generic.model.Preference

internal sealed class MultiChoicePreference: Preference() {
    abstract override val defaultValue: Set<String>
    abstract val entries: List<String>
    abstract val entryValues: List<String>

    data class Custom(
        override val key: String,
        override val title: String,
        override val description: String?,
        override val defaultValue: Set<String>,
        override val entries: List<String>,
        override val entryValues: List<String>,
        val tooltipEnabled: Boolean,
        val valueFormatter: (List<String>) -> String,
    ): MultiChoicePreference()

    data class Default(
        override val key: String,
        override val title: String,
        override val description: String?,
        override val defaultValue: Set<String>,
        override val entries: List<String>,
        override val entryValues: List<String>,
    ): MultiChoicePreference()
}