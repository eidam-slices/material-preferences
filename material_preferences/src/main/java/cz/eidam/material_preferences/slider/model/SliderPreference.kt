package cz.eidam.material_preferences.slider.model

import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.generic.model.Preference

internal data class SliderPreference(
    override val key: String,
    override val title: Text,
    override val description: Text?,
    override val defaultValue: Float,
    val valueRange: ClosedFloatingPointRange<Float>,
    val step: Float,
    val transform: (Float) -> String
): Preference()