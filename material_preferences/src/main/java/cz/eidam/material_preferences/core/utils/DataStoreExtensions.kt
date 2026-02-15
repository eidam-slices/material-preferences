package cz.eidam.material_preferences.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import cz.eidam.material_preferences.core.utils.serializers.FloatRangeSerializer.deserializeFloatRange
import cz.eidam.material_preferences.core.utils.serializers.FloatRangeSerializer.serializeFloatRange
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.reflect.KClass

// * STRING:
suspend fun DataStore<Preferences>.setString(key: String, value: String) {
    this.edit {
        it[stringPreferencesKey(key)] = value
    }
}

fun DataStore<Preferences>.getStringFlow(
    key: String,
    defaultValue: String
): Flow<String> {
    return this.data.map { preferences ->
        preferences.safeGet(stringPreferencesKey(key)) ?: defaultValue
    }
}

@Composable
fun DataStore<Preferences>.getStringState(
    key: String,
    defaultValue: String
) = this.getStringFlow(key, defaultValue)
    .collectAsState(defaultValue)


// * FLOAT:
suspend fun DataStore<Preferences>.setFloat(key: String, value: Float) {
    this.edit {
        it[floatPreferencesKey(key)] = value
    }
}

fun DataStore<Preferences>.getFloatFlow(
    key: String,
    defaultValue: Float,
): Flow<Float> {
    return this.data.map { preferences ->
        preferences.safeGet(floatPreferencesKey(key))
            ?: defaultValue
    }
}

@Composable
fun DataStore<Preferences>.getFloatState(
    key: String,
    defaultValue: Float,
) = this.getFloatFlow(key, defaultValue)
    .collectAsState(defaultValue)


// * BOOLEAN:
suspend fun DataStore<Preferences>.setBoolean(key: String, value: Boolean) {
    this.edit {
        it[booleanPreferencesKey(key)] = value
    }
}

fun DataStore<Preferences>.getBooleanFlow(
    key: String,
    defaultValue: Boolean,
): Flow<Boolean> {
    return this.data.map { preferences ->
        preferences.safeGet(booleanPreferencesKey(key))
            ?: defaultValue
    }
}

@Composable
fun DataStore<Preferences>.getBooleanState(
    key: String,
    defaultValue: Boolean,
) = this.getBooleanFlow(key, defaultValue)
    .collectAsState(defaultValue)


// * STRING SET:
suspend fun DataStore<Preferences>.setStringSet(key: String, value: Set<String>) {
    this.edit {
        it[stringSetPreferencesKey(key)] = value
    }
}

fun DataStore<Preferences>.getStringSetFlow(
    key: String,
    defaultValue: Set<String>,
): Flow<Set<String>> {
    return this.data.map { preferences ->
        preferences.safeGet(stringSetPreferencesKey(key))
            ?: defaultValue
    }
}

@Composable
fun DataStore<Preferences>.getStringSetState(
    key: String,
    defaultValue: Set<String>,
) = this.getStringSetFlow(key, defaultValue)
    .collectAsState(defaultValue)


// * FLOAT RANGE:
suspend fun DataStore<Preferences>.setFloatRange(
    key: String,
    value: ClosedFloatingPointRange<Float>
) {
    this.edit {
        it[stringPreferencesKey(key)] = serializeFloatRange(value)
    }
}

fun DataStore<Preferences>.getFloatRangeFlow(
    key: String,
    defaultValue: ClosedFloatingPointRange<Float>,
): Flow<ClosedFloatingPointRange<Float>> {
    return this.data.map { preferences ->
        preferences.safeGet(stringPreferencesKey(key))?.let { serialized ->
            deserializeFloatRange(serialized)
        } ?: defaultValue
    }
}

@Composable
fun DataStore<Preferences>.getFloatRangeState(
    key: String,
    defaultValue: ClosedFloatingPointRange<Float>,
) = this.getFloatRangeFlow(key, defaultValue)
    .collectAsState(defaultValue)


// * ENUM:
suspend fun <E: Enum<E>> DataStore<Preferences>.setEnum(key: String, value: E) {
    this.edit {
        it[stringPreferencesKey(key)] = value.name
    }
}

inline fun <reified E: Enum<E>> DataStore<Preferences>.getEnumFlow(
    key: String,
    defaultValue: E
): Flow<E> {
    return this.data.map { preferences ->
        val stored = preferences.safeGet(stringPreferencesKey(key))
        stored?.let { stored ->
            enumValueOf<E>(stored)
        } ?: defaultValue
    }
}

fun <E: Enum<E>> DataStore<Preferences>.getEnumFlow(
    key: String,
    defaultValue: E,
    kclass: KClass<E>
): Flow<E> {
    return this.data.map { preferences ->
        val stored = preferences.safeGet(stringPreferencesKey(key))
        stored?.let { stored ->
            java.lang.Enum.valueOf(kclass.java, stored)
        } ?: defaultValue
    }
}

@Composable
inline fun <reified E: Enum<E>> DataStore<Preferences>.getEnumState(
    key: String,
    defaultValue: E
) = this.getEnumFlow(key, defaultValue)
    .collectAsState(defaultValue)



// SAFE GET FUNCTION:
inline fun <reified T> Preferences.safeGet(key: Preferences.Key<T>): T? {
    val stored: Any? = this[key]
    @Suppress("IfThenToSafeAccess")
    return if (stored is T) stored else null
}