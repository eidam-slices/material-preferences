package cz.eidam.material_preferences.core.dsl

import androidx.annotation.StringRes
import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.slider.model.SliderPreference


// String Overload
fun PreferenceScope.slider(
    key: String,
    title: String,
    description: String,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: Float,
    step: Float,
    valueFormatter: (Float) -> String,
) = add {
    SliderPreference.Custom(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        valueFormatter = valueFormatter,
    )
}

// String Resource Overload
fun PreferenceScope.slider(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: Float,
    step: Float,
    valueFormatter: (Float) -> String,
) = add {
    SliderPreference.Custom(
        key = key,
        title = Text(title)!!,
        description = Text(description),
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
    description: String,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: Float,
    step: Float,
    unit: String,
) = add {
    SliderPreference.WithUnit(
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
fun PreferenceScope.slider(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: Float,
    step: Float,
    unit: String,
) = add {
    SliderPreference.WithUnit(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        unit = unit,
    )
}