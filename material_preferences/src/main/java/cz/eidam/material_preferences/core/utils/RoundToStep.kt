package cz.eidam.material_preferences.core.utils

import kotlin.math.roundToInt

fun Float.roundToStep(step: Float): Float {
    return if (step > 0) (this / step).roundToInt() * step
    else this
}

fun ClosedFloatingPointRange<Float>.roundToStep(step: Float): ClosedFloatingPointRange<Float> {
    return start.roundToStep(step)..endInclusive.roundToStep(step)
}