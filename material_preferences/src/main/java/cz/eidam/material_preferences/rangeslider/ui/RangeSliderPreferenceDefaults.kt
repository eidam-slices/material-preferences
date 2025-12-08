package cz.eidam.material_preferences.rangeslider.ui

import cz.eidam.material_preferences.core.utils.createSliderNumberFormatter

object RangeSliderPreferenceDefaults {

    fun unitFormatter(step: Float, unit: String): (ClosedFloatingPointRange<Float>) -> String {
        val formatter = createSliderNumberFormatter(step)

        return { value ->
            "${formatter.format(value.start)} – ${formatter.format(value.endInclusive)} $unit"
        }
    }
}