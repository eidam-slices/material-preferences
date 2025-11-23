package cz.eidam.material_preferences.multichoice.model

import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.generic.model.Preference

internal data class MultiChoicePreference(
    override val key: String,
    override val title: Text,
    override val description: Text?,
    override val defaultValue: Set<String>,
    val entries: List<Text>,
    val entryValues: List<String>,
): Preference()