package cz.eidam.material_preferences

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.utils.dataStore
import cz.eidam.material_preferences.core.utils.getBooleanFlow
import cz.eidam.material_preferences.core.utils.getBooleanState
import cz.eidam.material_preferences.core.utils.getFloatFlow
import cz.eidam.material_preferences.core.utils.getFloatRangeFlow
import cz.eidam.material_preferences.core.utils.getFloatRangeState
import cz.eidam.material_preferences.core.utils.getFloatState
import cz.eidam.material_preferences.core.utils.getStringFlow
import cz.eidam.material_preferences.core.utils.getStringSetFlow
import cz.eidam.material_preferences.core.utils.getStringSetState
import cz.eidam.material_preferences.core.utils.getStringState
import cz.eidam.material_preferences.core.utils.setBoolean
import cz.eidam.material_preferences.core.utils.setFloat
import cz.eidam.material_preferences.core.utils.setFloatRange
import cz.eidam.material_preferences.core.utils.setString
import cz.eidam.material_preferences.core.utils.setStringSet
import kotlinx.coroutines.flow.Flow

class Preferences(val dataStore: DataStore<Preferences>) {

    constructor(context: Context): this(context.dataStore)


    //*region———— COLLECT AS STATE FUNCTIONS ————————————————————————————
    @Composable
    fun getBooleanState(key: String, defaultValue: Boolean) =
        dataStore.getBooleanState(key, defaultValue)

    @Composable
    fun getFloatState(key: String, defaultValue: Float) =
        dataStore.getFloatState(key, defaultValue)

    @Composable
    fun getFloatRangeState(key: String, defaultValue: ClosedFloatingPointRange<Float>) =
        dataStore.getFloatRangeState(key, defaultValue)

    @Composable
    fun getStringState(key: String, defaultValue: String) =
        dataStore.getStringState(key, defaultValue)

    @Composable
    fun getStringSetState(key: String, defaultValue: Set<String>) =
        dataStore.getStringSetState(key, defaultValue)
    // endregion

    //*region———— GET FLOW FUNCTIONS ————————————————————————————
    fun getBooleanFlow(key: String, defaultValue: Boolean): Flow<Boolean> {
        return dataStore.getBooleanFlow(key, defaultValue)
    }

    fun getFloatFlow(key: String, defaultValue: Float): Flow<Float> {
        return dataStore.getFloatFlow(key, defaultValue)
    }

    fun getFloatRangeFlow(
        key: String,
        defaultValue: ClosedFloatingPointRange<Float>
    ): Flow<ClosedFloatingPointRange<Float>> {
        return dataStore.getFloatRangeFlow(key, defaultValue)
    }

    fun getStringFlow(key: String, defaultValue: String): Flow<String> {
        return dataStore.getStringFlow(key, defaultValue)
    }

    fun getStringSetFlow(key: String, defaultValue: Set<String>): Flow<Set<String>> {
        return dataStore.getStringSetFlow(key, defaultValue)
    }
    // endregion

    //* region———— SET FUNCTIONS ————————————————————————————
    suspend fun setBoolean(key: String, value: Boolean) =
        dataStore.setBoolean(key, value)

    suspend fun setFloat(key: String, value: Float) =
        dataStore.setFloat(key, value)

    suspend fun setFloatRange(key: String, value: ClosedFloatingPointRange<Float>) =
        dataStore.setFloatRange(key, value)

    suspend fun setString(key: String, value: String) =
        dataStore.setString(key, value)

    suspend fun setStringSet(key: String, value: Set<String>) =
        dataStore.setStringSet(key, value)
    // endregion
}