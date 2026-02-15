package cz.eidam.demo_koin

import cz.eidam.material_preferences.utils.Preferences
import org.koin.dsl.module

val preferencesModule = module {
    single {
        Preferences(
            context = get()
        )
    }
}