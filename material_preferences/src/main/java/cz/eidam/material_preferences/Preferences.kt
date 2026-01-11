package cz.eidam.material_preferences

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.utils.dataStore
import cz.eidam.material_preferences.core.utils.getBooleanFlow
import cz.eidam.material_preferences.core.utils.getBooleanState
import cz.eidam.material_preferences.core.utils.getEnumFlow
import cz.eidam.material_preferences.core.utils.getEnumState
import cz.eidam.material_preferences.core.utils.getFloatFlow
import cz.eidam.material_preferences.core.utils.getFloatRangeFlow
import cz.eidam.material_preferences.core.utils.getFloatRangeState
import cz.eidam.material_preferences.core.utils.getFloatState
import cz.eidam.material_preferences.core.utils.getStringFlow
import cz.eidam.material_preferences.core.utils.getStringSetFlow
import cz.eidam.material_preferences.core.utils.getStringSetState
import cz.eidam.material_preferences.core.utils.getStringState
import cz.eidam.material_preferences.core.utils.setBoolean
import cz.eidam.material_preferences.core.utils.setEnum
import cz.eidam.material_preferences.core.utils.setFloat
import cz.eidam.material_preferences.core.utils.setFloatRange
import cz.eidam.material_preferences.core.utils.setString
import cz.eidam.material_preferences.core.utils.setStringSet
import kotlinx.coroutines.flow.Flow

class Preferences(val dataStore: DataStore<Preferences>) {

    constructor(context: Context): this(context.dataStore)


    // * STRING:
    suspend fun setString(key: String, value: String) =
        dataStore.setString(key, value)

    fun getStringFlow(key: String, defaultValue: String): Flow<String> =
        dataStore.getStringFlow(key, defaultValue)

    @Composable
    fun getStringState(key: String, defaultValue: String) =
        dataStore.getStringState(key, defaultValue)


    // * BOOLEAN:
    suspend fun setBoolean(key: String, value: Boolean) =
        dataStore.setBoolean(key, value)

    fun getBooleanFlow(key: String, defaultValue: Boolean): Flow<Boolean> =
        dataStore.getBooleanFlow(key, defaultValue)

    @Composable
    fun getBooleanState(key: String, defaultValue: Boolean) =
        dataStore.getBooleanState(key, defaultValue)


    // * FLOAT:
    suspend fun setFloat(key: String, value: Float) =
        dataStore.setFloat(key, value)

    fun getFloatFlow(key: String, defaultValue: Float): Flow<Float> =
        dataStore.getFloatFlow(key, defaultValue)

    @Composable
    fun getFloatState(key: String, defaultValue: Float) =
        dataStore.getFloatState(key, defaultValue)


    // * STRING SET:
    suspend fun setStringSet(key: String, value: Set<String>) =
        dataStore.setStringSet(key, value)

    fun getStringSetFlow(key: String, defaultValue: Set<String>): Flow<Set<String>> =
        dataStore.getStringSetFlow(key, defaultValue)

    @Composable
    fun getStringSetState(key: String, defaultValue: Set<String>) =
        dataStore.getStringSetState(key, defaultValue)


    // * FLOAT RANGE:
    suspend fun setFloatRange(key: String, value: ClosedFloatingPointRange<Float>) =
        dataStore.setFloatRange(key, value)

    fun getFloatRangeFlow(
        key: String,
        defaultValue: ClosedFloatingPointRange<Float>
    ): Flow<ClosedFloatingPointRange<Float>> = dataStore.getFloatRangeFlow(key, defaultValue)

    @Composable
    fun getFloatRangeState(key: String, defaultValue: ClosedFloatingPointRange<Float>) =
        dataStore.getFloatRangeState(key, defaultValue)


    // * ENUM:
    suspend fun <E: Enum<E>> setEnum(key: String, value: E) =
        dataStore.setEnum(key, value)

    inline fun <reified E: Enum<E>> getEnumFlow(key: String, defaultValue: E): Flow<E> =
        dataStore.getEnumFlow(key, defaultValue)

    @Composable
    inline fun <reified E: Enum<E>> getEnumState(key: String, defaultValue: E) =
        dataStore.getEnumState(key, defaultValue)

}