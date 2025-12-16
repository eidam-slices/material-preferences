package cz.eidam.material_preferences.choice.model

import cz.eidam.material_preferences.generic.model.Preference

internal data class ChoicePreference(
    override val key: String,
    override val title: String,
    override val description: String?,
    override val defaultValue: String,
    val entries: List<String>,
    val entryValues: List<String>,
): Preference()