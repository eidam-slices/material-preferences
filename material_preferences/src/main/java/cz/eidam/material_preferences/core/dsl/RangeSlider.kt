package cz.eidam.material_preferences.core.dsl

import androidx.annotation.StringRes
import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.rangeslider.model.RangeSliderPreference

// String / Custom Overload
fun PreferenceScope.rangeSlider(
    key: String,
    title: String,
    description: String?,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: ClosedFloatingPointRange<Float>,
    step: Float,
    transform: (ClosedFloatingPointRange<Float>) -> String,
) = add {
    RangeSliderPreference.Custom(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        transform = transform,
    )
}

// String Resource / Custom Overload
fun PreferenceScope.rangeSlider(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int?,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: ClosedFloatingPointRange<Float>,
    step: Float,
    transform: (ClosedFloatingPointRange<Float>) -> String,
) = add {
    RangeSliderPreference.Custom(
        key = key,
        title = Text(title)!!,
        description = Text(description),
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
    description: String?,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: ClosedFloatingPointRange<Float>,
    step: Float,
    unit: String,
) = add {
    RangeSliderPreference.WithUnit(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        unit = unit,
    )
}

// String Resource / Unit Overload
fun PreferenceScope.rangeSlider(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int?,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: ClosedFloatingPointRange<Float>,
    step: Float,
    unit: String,
) = add {
    RangeSliderPreference.WithUnit(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        unit = unit,
    )
}