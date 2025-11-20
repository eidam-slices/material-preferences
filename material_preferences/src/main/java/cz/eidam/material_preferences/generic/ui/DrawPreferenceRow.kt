package cz.eidam.material_preferences.generic.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
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