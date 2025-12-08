package cz.eidam.material_preferences.core.utils

import java.text.NumberFormat
import java.util.Locale

internal fun createSliderNumberFormatter(step: Float): NumberFormat {
    return NumberFormat.getInstance(Locale.getDefault()).apply {
        val stepIsDecimal = step % 1 != 0f

        minimumFractionDigits = if (stepIsDecimal) 1 else 0
        maximumFractionDigits = if (stepIsDecimal) 7 else 0
        isGroupingUsed = false
    }
}
