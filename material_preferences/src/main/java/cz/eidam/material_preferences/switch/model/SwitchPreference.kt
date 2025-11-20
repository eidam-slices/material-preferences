package cz.eidam.material_preferences.switch.model

import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.generic.model.Preference

internal data class SwitchPreference(
    override val key: String,
    override val title: Text,
    override val description: Text?,
    override val defaultValue: Boolean,
): Preference()