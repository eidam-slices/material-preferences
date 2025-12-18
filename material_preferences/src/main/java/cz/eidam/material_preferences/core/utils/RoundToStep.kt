package cz.eidam.material_preferences.core.utils

import kotlin.math.pow
import kotlin.math.round

fun Float.roundToStep(step: Float): Float {
    if (step <= 0f) return this

    val decimals = step
        .toString()
        .substringAfter('.', "")
        .trimEnd('0')
        .length

    val factor = 10.0.pow(decimals.toDouble())

    val stepped = round((this / step).toDouble()) * step
    val rounded = round(stepped * factor) / factor

    return rounded.toFloat()
}

fun ClosedFloatingPointRange<Float>.roundToStep(step: Float): ClosedFloatingPointRange<Float> {
    return start.roundToStep(step)..endInclusive.roundToStep(step)
}