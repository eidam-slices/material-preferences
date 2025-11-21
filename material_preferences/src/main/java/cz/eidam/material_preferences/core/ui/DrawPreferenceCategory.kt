package cz.eidam.material_preferences.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.category.model.PreferenceCategory

@Composable
internal fun DrawPreferenceCategory(
    category: PreferenceCategory,
    dataStore: DataStore<Preferences>
) {
    var expanded by rememberSaveable { mutableStateOf(true) }

    cz.eidam.material_preferences.category.ui.PreferenceCategory(
        title = category.title?.value(),
        onExpandedChange = if (category.collapsible) {
            { expanded = it }
        } else null,
        expanded = if (category.collapsible) expanded else null,
    ) {
        category.all.forEach { preference ->
            DrawPreferenceRow(preference, dataStore)
        }
    }
}