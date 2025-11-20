package cz.eidam.material_preferences.generic.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.composable.choice.PersistentPreferenceChoice
import cz.eidam.material_preferences.category.ui.DrawPreferenceCategory
import cz.eidam.material_preferences.composable.multi_choice.PersistentPreferenceMultiChoice
import cz.eidam.material_preferences.composable.range_slider.PersistentPreferenceRangeSlider
import cz.eidam.material_preferences.composable.slider.PersistentPreferenceSlider
import cz.eidam.material_preferences.composable.switch.PersistentPreferenceSwitch
import cz.eidam.material_preferences.generic.model.PreferenceRow


@Composable
internal fun DrawPreferenceRow(
    preference: PreferenceRow,
    dataStore: DataStore<Preferences>
) {
    when (val preference = preference) {
        else -> Log.e("DrawPreferenceRow", "Failed to draw PreferenceRow. Unsupported PreferenceRow type: $preference")
    }
}