package cz.eidam.material_preferences.core.utils.serializers

import androidx.compose.runtime.saveable.listSaver

internal object FloatRangeSerializer {
    internal val FloatRangeSaver = listSaver<ClosedFloatingPointRange<Float>, Float>(
        save = { listOf(it.start, it.endInclusive) },
        restore = { (start, endInclusive) ->
            start..endInclusive
        }
    )
}