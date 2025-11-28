package cz.eidam.material_preferences.core.utils

import androidx.compose.runtime.saveable.listSaver

val FloatRangeSaver = listSaver<ClosedFloatingPointRange<Float>, Float>(
    save = { listOf(it.start, it.endInclusive) },
    restore = { (start, endInclusive) ->
        start..endInclusive
    }
)