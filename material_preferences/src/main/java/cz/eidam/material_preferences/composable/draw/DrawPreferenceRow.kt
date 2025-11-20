package cz.eidam.material_preferences.composable.draw

import android.util.Log
import androidx.compose.runtime.Composable
import cz.eidam.material_preferences.model.PreferenceRow

@Composable
internal fun DrawPreferenceRow(
    preference: PreferenceRow,
) {
    when (val preference = preference) {
        else -> Log.e("DrawPreferenceRow", "Failed to draw PreferenceRow. Unsupported PreferenceRow type: $preference")
    }
}