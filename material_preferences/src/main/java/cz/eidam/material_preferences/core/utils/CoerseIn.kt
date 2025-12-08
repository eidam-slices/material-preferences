package cz.eidam.material_preferences.core.utils


fun ClosedFloatingPointRange<Float>.coerceIn(range: ClosedFloatingPointRange<Float>): ClosedFloatingPointRange<Float> {
    return start.coerceIn(range)..endInclusive.coerceIn(range)
}