package cz.eidam.material_preferences.slider.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.utils.getFloatState
import cz.eidam.material_preferences.core.utils.setFloat
import kotlinx.coroutines.launch

@Composable
fun DataStorePreferenceSlider(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: Float,
    valueRange: ClosedFloatingPointRange<Float>,
    step: Float,
    transform: (Float) -> String = SliderPreferenceDefaults.unitFormatter(step, ""),
    dataStore: DataStore<Preferences>,
) {
    val value by dataStore.getFloatState(key, defaultValue)

    val scope = rememberCoroutineScope()
    PreferenceSlider(
        title = title,
        description = description,
        valueRange = valueRange,
        step = step,
        transform = transform,

        value = value,
        onValueChange = { updated ->
            scope.launch {
                dataStore.setFloat(key, updated)
            }
        }
    )
}