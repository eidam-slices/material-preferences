package cz.eidam.material_preferences.ui.utils

import androidx.compose.runtime.Composable
import cz.eidam.material_preferences.core.utils.getBooleanState
import cz.eidam.material_preferences.core.utils.getEnumState
import cz.eidam.material_preferences.core.utils.getFloatRangeState
import cz.eidam.material_preferences.core.utils.getFloatState
import cz.eidam.material_preferences.core.utils.getStringSetState
import cz.eidam.material_preferences.core.utils.getStringState
import cz.eidam.material_preferences.utils.Preferences


@Composable
fun Preferences.getStringState(key: String, defaultValue: String) =
    dataStore.getStringState(key, defaultValue)

@Composable
fun Preferences.getBooleanState(key: String, defaultValue: Boolean) =
    dataStore.getBooleanState(key, defaultValue)

@Composable
fun Preferences.getFloatState(key: String, defaultValue: Float) =
    dataStore.getFloatState(key, defaultValue)

@Composable
fun Preferences.getStringSetState(key: String, defaultValue: Set<String>) =
    dataStore.getStringSetState(key, defaultValue)

@Composable
fun Preferences.getFloatRangeState(key: String, defaultValue: ClosedFloatingPointRange<Float>) =
    dataStore.getFloatRangeState(key, defaultValue)

@Composable
inline fun <reified E: Enum<E>> Preferences.getEnumState(key: String, defaultValue: E) =
    dataStore.getEnumState(key, defaultValue)
