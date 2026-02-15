package cz.eidam.material_preferences.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.core.utils.createDataStore
import cz.eidam.material_preferences.core.utils.getBooleanFlow
import cz.eidam.material_preferences.core.utils.getEnumFlow
import cz.eidam.material_preferences.core.utils.getFloatFlow
import cz.eidam.material_preferences.core.utils.getFloatRangeFlow
import cz.eidam.material_preferences.core.utils.getStringFlow
import cz.eidam.material_preferences.core.utils.getStringSetFlow
import cz.eidam.material_preferences.core.utils.setBoolean
import cz.eidam.material_preferences.core.utils.setEnum
import cz.eidam.material_preferences.core.utils.setFloat
import cz.eidam.material_preferences.core.utils.setFloatRange
import cz.eidam.material_preferences.core.utils.setString
import cz.eidam.material_preferences.core.utils.setStringSet
import kotlinx.coroutines.flow.Flow
import kotlin.reflect.KClass

class Preferences(val dataStore: DataStore<Preferences>) {

    constructor(context: Context, name: String = DEFAULT_DATA_STORE_NAME)
            : this(createDataStore(context, name))

    companion object {
        const val DEFAULT_DATA_STORE_NAME = "preferences.preferences_pb"
    }

    // * STRING:
    suspend fun setString(key: String, value: String) =
        dataStore.setString(key, value)

    fun getStringFlow(key: String, defaultValue: String): Flow<String> =
        dataStore.getStringFlow(key, defaultValue)


    // * BOOLEAN:
    suspend fun setBoolean(key: String, value: Boolean) =
        dataStore.setBoolean(key, value)

    fun getBooleanFlow(key: String, defaultValue: Boolean): Flow<Boolean> =
        dataStore.getBooleanFlow(key, defaultValue)


    // * FLOAT:
    suspend fun setFloat(key: String, value: Float) =
        dataStore.setFloat(key, value)

    fun getFloatFlow(key: String, defaultValue: Float): Flow<Float> =
        dataStore.getFloatFlow(key, defaultValue)


    // * STRING SET:
    suspend fun setStringSet(key: String, value: Set<String>) =
        dataStore.setStringSet(key, value)

    fun getStringSetFlow(key: String, defaultValue: Set<String>): Flow<Set<String>> =
        dataStore.getStringSetFlow(key, defaultValue)


    // * FLOAT RANGE:
    suspend fun setFloatRange(key: String, value: ClosedFloatingPointRange<Float>) =
        dataStore.setFloatRange(key, value)

    fun getFloatRangeFlow(
        key: String,
        defaultValue: ClosedFloatingPointRange<Float>
    ): Flow<ClosedFloatingPointRange<Float>> = dataStore.getFloatRangeFlow(key, defaultValue)


    // * ENUM:
    suspend fun <E: Enum<E>> setEnum(key: String, value: E) =
        dataStore.setEnum(key, value)

    fun <E: Enum<E>> getEnumFlow(key: String, defaultValue: E, kclass: KClass<E>): Flow<E> =
        dataStore.getEnumFlow(key, defaultValue, kclass)

    inline fun <reified E: Enum<E>> getEnumFlow(key: String, defaultValue: E): Flow<E> =
        dataStore.getEnumFlow(key, defaultValue)


}