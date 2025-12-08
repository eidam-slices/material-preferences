package cz.eidam.material_preferences.slider.ui

import cz.eidam.material_preferences.core.utils.createSliderNumberFormatter

object SliderPreferenceDefaults {



    fun unitFormatter(step: Float, unit: String): (Float) -> String {
        val formatter = createSliderNumberFormatter(step)
        return { value ->
            formatter.format(value) + " " + unit
        }
    }
}