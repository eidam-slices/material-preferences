package cz.eidam.material_preferences.switch.model

import cz.eidam.material_preferences.generic.model.Preference

internal data class SwitchPreference(
    override val key: String,
    override val title: String,
    override val description: String?,
    override val defaultValue: Boolean,
): Preference()