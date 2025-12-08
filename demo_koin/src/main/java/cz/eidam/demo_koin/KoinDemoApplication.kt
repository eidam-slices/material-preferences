package cz.eidam.demo_koin

import android.app.Application
import android.util.Log
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class KoinDemoApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinDemoApplication)
            modules(preferencesModule)
        }
        Log.i("KoinDemoApplication", "Koin started with preferences module")
    }
}