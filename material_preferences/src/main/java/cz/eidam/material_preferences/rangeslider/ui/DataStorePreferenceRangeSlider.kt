package cz.eidam.material_preferences.rangeslider.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.utils.getFloatRangeState
import cz.eidam.material_preferences.core.utils.setFloatRange
import kotlinx.coroutines.launch

@Composable
fun DataStorePreferenceRangeSlider(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: ClosedFloatingPointRange<Float>,
    valueRange: ClosedFloatingPointRange<Float>,
    step: Float,
    transform: (ClosedFloatingPointRange<Float>) -> String =
        RangeSliderPreferenceDefaults.unitFormatter(step, ""),
    dataStore: DataStore<Preferences>,
) {
    val value by dataStore.getFloatRangeState(key, defaultValue)

    val scope = rememberCoroutineScope()
    PreferenceRangeSlider(
        title = title,
        description = description,
        valueRange = valueRange,
        step = step,
        transform = transform,

        value = value,
        onValueChange = { updated ->
            scope.launch {
                dataStore.setFloatRange(key, updated)
            }
        }
    )
}