package cz.eidam.demo_manual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cz.eidam.demo_shared.DependentPreferencesDemoScreen
import cz.eidam.demo_shared.DependentPreferencesScreenKey
import cz.eidam.demo_shared.PreferencesDemoScreen
import cz.eidam.demo_shared.PreferencesScreenKey
import cz.eidam.demo_shared.ReadingPreferencesDemoScreen
import cz.eidam.demo_shared.ReadingPreferencesScreenKey
import cz.eidam.demo_shared.theme.MaterialPreferencesTheme
import cz.eidam.material_preferences.Preferences

lateinit var preferences: Preferences

class ManualDemoActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val backStack = remember { mutableStateListOf(PreferencesScreenKey) }

            MaterialPreferencesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    val modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)


                    when (backStack.lastOrNull()) {
                        PreferencesScreenKey -> {
                            PreferencesDemoScreen(
                                modifier = modifier,
                                onNavigate = { backStack.add(it) }
                            )
                        }

                        ReadingPreferencesScreenKey -> {
                            ReadingPreferencesDemoScreen(
                                preferences = preferences,
                                modifier = modifier,
                                onGoBack = { backStack.removeLastOrNull() }
                            )
                        }

                        DependentPreferencesScreenKey -> {
                            DependentPreferencesDemoScreen(
                                modifier = modifier,
                                onGoBack = { backStack.removeLastOrNull() }
                            )
                        }

                        null -> {
                            Box(modifier, contentAlignment = Alignment.Center) {
                                Text(
                                    text = "No screen selected",
                                    style = MaterialTheme.typography.headlineMedium,
                                )
                            }
                        }
                    }
                }


            }
        }
    }
}