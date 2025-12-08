package cz.eidam.material_preferences.choice.model

import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.generic.model.Preference

internal data class ChoicePreference(
    override val key: String,
    override val title: Text,
    override val description: Text?,
    override val defaultValue: String,
    val entries: List<Text>,
    val entryValues: List<String>,
): Preference()