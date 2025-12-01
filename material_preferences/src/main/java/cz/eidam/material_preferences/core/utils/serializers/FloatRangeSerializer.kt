package cz.eidam.material_preferences.core.utils.serializers

import androidx.compose.runtime.saveable.listSaver

internal object FloatRangeSerializer {
    internal val FloatRangeSaver = listSaver<ClosedFloatingPointRange<Float>, Float>(
        save = { listOf(it.start, it.endInclusive) },
        restore = { (start, endInclusive) ->
            start..endInclusive
        }
    )
    private const val SEPARATOR = "-"

    internal fun serializeFloatRange(
        range: ClosedFloatingPointRange<Float>
    ): String {
        return "${range.start}${SEPARATOR}${range.endInclusive}"
    }

    internal fun deserializeFloatRange(serialized: String): ClosedFloatingPointRange<Float>? {
        val (start, endInclusive) = serialized.split(SEPARATOR)
            .map { it.toFloatOrNull() ?: return null }
        return start..endInclusive
    }
}