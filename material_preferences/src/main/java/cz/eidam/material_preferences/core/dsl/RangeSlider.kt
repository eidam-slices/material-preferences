package cz.eidam.material_preferences.core.dsl

import cz.eidam.material_preferences.rangeslider.model.RangeSliderPreference

// String / Custom Overload
fun PreferenceScope.rangeSlider(
    key: String,
    title: String,
    description: String? = null,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: ClosedFloatingPointRange<Float>,
    step: Float,
    transform: (ClosedFloatingPointRange<Float>) -> String,
) = add {
    RangeSliderPreference.Custom(
        key = key,
        title = title,
        description = description,
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        transform = transform,
    )
}

// String / Unit Overload
fun PreferenceScope.rangeSlider(
    key: String,
    title: String,
    description: String? = null,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: ClosedFloatingPointRange<Float>,
    step: Float,
    unit: String,
) = add {
    RangeSliderPreference.WithUnit(
        key = key,
        title = title,
        description = description,
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        unit = unit,
    )
}