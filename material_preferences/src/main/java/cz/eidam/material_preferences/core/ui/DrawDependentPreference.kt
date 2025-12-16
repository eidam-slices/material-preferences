package cz.eidam.material_preferences.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import cz.eidam.material_preferences.core.dsl.PreferenceScope
import cz.eidam.material_preferences.generic.model.DependentPreference
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

@Composable
fun <T> DrawDependentPreference(
    dependentPreference: DependentPreference<T>,
    dataStore: DataStore<Preferences>,
) {
    val value by remember(dependentPreference.dependencyKey) {
        dataStore.data.map { preferences ->
            val any: Any? = preferences[stringPreferencesKey(dependentPreference.dependencyKey)]
            val string = any?.toString()

            string?.let { dependentPreference.deserialize(it) } ?: dependentPreference.defaultValue
        }.distinctUntilChanged()
    }.collectAsState(dependentPreference.defaultValue)

    val scope = PreferenceScope()
    scope.clear()
    dependentPreference.content.invoke(scope, value)

    scope.all.forEach { preference ->
        DrawPreferenceRow(preference, dataStore)
    }
}