package cz.eidam.demo_koin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cz.eidam.demo_shared.PreferencesDemoScreen
import cz.eidam.demo_shared.PreferencesScreenKey
import cz.eidam.demo_shared.ReadingPreferencesDemoScreen
import cz.eidam.demo_shared.ReadingPreferencesScreenKey
import cz.eidam.demo_shared.theme.MaterialPreferencesTheme
import org.koin.compose.koinInject

class KoinDemoActivity: ComponentActivity() {
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


                    when (val current = backStack.lastOrNull()) {
                        PreferencesScreenKey -> {
                            PreferencesDemoScreen(
                                modifier = modifier,
                                onGoToReading = {
                                    backStack.add(ReadingPreferencesScreenKey)
                                }
                            )
                        }

                        ReadingPreferencesScreenKey -> {
                            ReadingPreferencesDemoScreen(
                                preferences = koinInject(),
                                modifier = modifier,
                                onGoBack = {
                                    backStack.removeLastOrNull()
                                }
                            )
                        }

                        null -> {
                            Box(modifier) {
                                Text("Nothing Selected")
                            }
                        }

                        else -> error("Unknown screen key: $current")
                    }

                }
            }
        }
    }
}