package cz.eidam.material_preferences.core.dsl

import cz.eidam.material_preferences.slider.model.SliderPreference


// String Overload
fun PreferenceScope.slider(
    key: String,
    title: String,
    description: String? = null,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: Float,
    step: Float,
    valueFormatter: (Float) -> String,
) = add {
    SliderPreference.Custom(
        key = key,
        title = title,
        description = description,
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        valueFormatter = valueFormatter,
    )
}

// String / Unit Overload
fun PreferenceScope.slider(
    key: String,
    title: String,
    description: String? = null,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: Float,
    step: Float,
    unit: String,
) = add {
    SliderPreference.WithUnit(
        key = key,
        title = title,
        description = description,
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        unit = unit,
    )
}