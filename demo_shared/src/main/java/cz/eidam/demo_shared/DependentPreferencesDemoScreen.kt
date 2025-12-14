package cz.eidam.demo_shared

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cz.eidam.material_preferences.core.dsl.choice
import cz.eidam.material_preferences.core.dsl.dependent
import cz.eidam.material_preferences.core.ui.Preferences

const val DependentPreferencesScreenKey = "dependent_preferences_demo"

@Composable
fun DependentPreferencesDemoScreen(
    modifier: Modifier = Modifier,
    onGoBack: () -> Unit,
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Preferences(Modifier.weight(1f)) {

            val entries = List(4) { "Option ${it + 1}" }
            val entryValues = List(4) { "option_${it + 1}" }
            val default = entryValues.first()

            choice(
                key = PreferenceKeys.EXAMPLE_DEPENDENCY_CHOICE,
                title = "Example Choice Dependency",
                description = "Select Option 3 to see more choices",
                entries = entries,
                entryValues = entryValues,
                defaultValue = default,
            )

            dependent(
                dependencyKey = PreferenceKeys.EXAMPLE_DEPENDENCY_CHOICE,
                serialize = { it },
                deserialize = { it },
                defaultValue = default,
            ) { dependency ->

                val targets = entryValues.takeLast(2)

                if (dependency in targets) {
                    choice(
                        key = PreferenceKeys.EXAMPLE_DEPENDENT_CHOICE,
                        title = "Dependent Choice",
                        description = "More options if Option 3 / 4 is selected",
                        entries = listOf("Dependent 1", "Dependent 2", "Dependent 3"),
                        entryValues = listOf("dependent_1", "dependent_2", "dependent_3"),
                        defaultValue = "dependent_1",
                    )
                }

            }
        }

        Button(
            onClick = onGoBack,
        ) { Text("Go Back") }
    }

}