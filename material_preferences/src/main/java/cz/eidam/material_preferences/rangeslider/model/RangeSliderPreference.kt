package cz.eidam.material_preferences.rangeslider.model

import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.generic.model.Preference

sealed class RangeSliderPreference: Preference() {

    abstract override val defaultValue: ClosedFloatingPointRange<Float>
    abstract val valueRange: ClosedFloatingPointRange<Float>
    abstract val step: Float

    data class Custom(
        override val key: String,
        override val title: Text,
        override val description: Text?,
        override val defaultValue: ClosedFloatingPointRange<Float>,
        override val valueRange: ClosedFloatingPointRange<Float>,
        override val step: Float,
        val transform: (ClosedFloatingPointRange<Float>) -> String,
    ): RangeSliderPreference()

    data class WithUnit(
        override val key: String,
        override val title: Text,
        override val description: Text?,
        override val defaultValue: ClosedFloatingPointRange<Float>,
        override val valueRange: ClosedFloatingPointRange<Float>,
        override val step: Float,
        val unit: String,
    ): RangeSliderPreference()
}