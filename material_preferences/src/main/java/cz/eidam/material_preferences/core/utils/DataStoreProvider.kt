package cz.eidam.material_preferences.core.utils

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

private const val DATA_STORE_EXTENSION = ".preferences_pb"

fun createDataStore(context: Context, name: String): DataStore<Preferences> {
    require(name.endsWith(DATA_STORE_EXTENSION)) {
        "Data Store name must have $DATA_STORE_EXTENSION extension"
    }

    Log.d("createDataStore()", "creating data store with name: $name at path: ${context.filesDir.resolve(name).absolutePath}")

    return PreferenceDataStoreFactory.createWithPath(
        produceFile = {
            context.filesDir.resolve(name).absolutePath.toPath()
        }
    )
}