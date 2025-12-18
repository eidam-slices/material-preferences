package cz.eidam.material_preferences.core.utils

import java.text.NumberFormat
import java.util.Locale

internal fun createSliderNumberFormatter(step: Float): NumberFormat {
    val decimals = step.toString()
        .substringAfter('.')
        .trimEnd('0')
        .length

    return NumberFormat.getInstance(Locale.getDefault()).apply {
        minimumFractionDigits = decimals
        maximumFractionDigits = decimals
        isGroupingUsed = false
    }
}
