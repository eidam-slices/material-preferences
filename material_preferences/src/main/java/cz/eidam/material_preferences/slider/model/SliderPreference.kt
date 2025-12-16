package cz.eidam.material_preferences.slider.model

import cz.eidam.material_preferences.generic.model.Preference

internal sealed class SliderPreference: Preference() {

    abstract override val defaultValue: Float
    abstract val valueRange: ClosedFloatingPointRange<Float>
    abstract val step: Float

    data class Custom(
        override val key: String,
        override val title: String,
        override val description: String?,
        override val defaultValue: Float,
        override val valueRange: ClosedFloatingPointRange<Float>,
        override val step: Float,
        val valueFormatter: (Float) -> String,
    ): SliderPreference()

    data class WithUnit(
        override val key: String,
        override val title: String,
        override val description: String?,
        override val defaultValue: Float,
        override val valueRange: ClosedFloatingPointRange<Float>,
        override val step: Float,
        val unit: String,
    ): SliderPreference()
}