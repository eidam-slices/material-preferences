package cz.eidam.demo_manual

import android.app.Application
import android.util.Log
import cz.eidam.material_preferences.Preferences

class ManualDemoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        preferences = Preferences(this@ManualDemoApplication)
        Log.i("ManualDemoApplication", "Preferences initialized")
    }
}