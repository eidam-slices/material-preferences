package cz.eidam.material_preferences.range_slider.model

import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.generic.model.Preference

data class RangeSliderPreference(
    override val key: String,
    override val title: Text,
    override val description: Text?,
    override val defaultValue: ClosedFloatingPointRange<Float>,
    val valueRange: ClosedFloatingPointRange<Float>,
    val step: Float,
    val transform: (ClosedFloatingPointRange<Float>) -> String,
): Preference()