package cz.eidam.material_preferences.core.dsl

import androidx.annotation.StringRes
import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.core.utils.createSliderNumberFormatter
import cz.eidam.material_preferences.slider.model.SliderPreference


// String Overload
fun PreferenceScope.slider(
    key: String,
    title: String,
    description: String,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: Float,
    step: Float,
    transform: (Float) -> String,
) = add {
    SliderPreference(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        transform = transform,
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
    transform: (Float) -> String,
) = add {
    SliderPreference(
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
fun PreferenceScope.slider(
    key: String,
    title: String,
    description: String,
    valueRange: ClosedFloatingPointRange<Float>,
    defaultValue: Float,
    step: Float,
    unit: String,
) = add {
    val formatter = createSliderNumberFormatter(step)
    SliderPreference(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        transform = { value ->
            formatter.format(value) + " " + unit
        },
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
    val formatter = createSliderNumberFormatter(step)
    SliderPreference(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        valueRange = valueRange,
        defaultValue = defaultValue,
        step = step,
        transform = { value ->
            formatter.format(value) + " " + unit
        },
    )
}