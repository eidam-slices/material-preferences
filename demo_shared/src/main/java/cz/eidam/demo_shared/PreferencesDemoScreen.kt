package cz.eidam.demo_shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.eidam.material_preferences.core.dsl.category
import cz.eidam.material_preferences.core.dsl.choice
import cz.eidam.material_preferences.core.dsl.collapsibleCategory
import cz.eidam.material_preferences.core.dsl.inlineTextField
import cz.eidam.material_preferences.core.dsl.multiChoice
import cz.eidam.material_preferences.core.dsl.rangeSlider
import cz.eidam.material_preferences.core.dsl.slider
import cz.eidam.material_preferences.core.dsl.switch
import cz.eidam.material_preferences.core.dsl.textField
import cz.eidam.material_preferences.ui.utils.Preferences
import cz.eidam.material_preferences.utils.Preferences

const val PreferencesScreenKey = "preferences_demo"

@Composable
fun PreferencesDemoScreen(
    preferences: Preferences,
    modifier: Modifier = Modifier,
    onNavigate: (String) -> Unit = { }
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Preferences Demo",
            style = MaterialTheme.typography.headlineMedium
        )

        Preferences(
            preferences = preferences,
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        )
        {
            switch(
                key = PreferenceKeys.EXAMPLE_SWITCH,
                title = "Example Switch",
                description = "A simple example of a switch preference",
                defaultValue = true,
            )

            category("Example Sliders Category") {
                slider(
                    key = PreferenceKeys.EXAMPLE_SLIDER,
                    title = "Example Slider",
                    description = "A simple example of a slider preference",
                    defaultValue = -25f,
                    valueRange = 0f..100f,
                    step = 12.5f,
                    // TODO: make it a optional parameter with default value
                    unit = "%"
                )

                rangeSlider(
                    key = PreferenceKeys.EXAMPLE_RANGE_SLIDER,
                    title = "Example Range Slider",
                    description = "A simple example of a range slider preference",
                    defaultValue = 0f..100f,
                    valueRange = 0f..300f,
                    step = 10f,
                    unit = "km",
                )
            }

            collapsibleCategory("Example Choices Collapsible Category") {

                val entryValues = List(4) { "value${it + 1}" }

                choice(
                    key = PreferenceKeys.EXAMPLE_CHOICE,
                    title = "Example Choice",
                    description = "A simple example of a choice preference",
                    defaultValue = entryValues.first(),
                    entries = List(4) { "Option ${it + 1}" },
                    entryValues = entryValues,
                )

                multiChoice(
                    key = PreferenceKeys.EXAMPLE_MULTI_CHOICE,
                    title = "Example Multi Choice",
                    description = "A simple example of a multi choice preference",
                    defaultValue = entryValues.take(2).toSet(),
                    entries = List(4) { "Option ${it + 1}" },
                    entryValues = entryValues,
                )
            }

            textField(
                key = PreferenceKeys.EXAMPLE_TEXT_FIELD,
                title = "Example Text Field",
                description = "A simple example of a text field preference",
                defaultValue = "Text"
            )


            inlineTextField(
                key = PreferenceKeys.EXAMPLE_INLINE_TEXT_FIELD,
                title = "Example Inline Text Field",
                description = "A simple example of an inline text field preference",
                defaultValue = "Inline Text"
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            val padding = 4.dp
            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = padding),
                onClick = { onNavigate(ReadingPreferencesScreenKey) }
            ) {
                Text(text = "Go to Reading Values")
            }
            Button(
                modifier = Modifier
                    .weight(1.1f)
                    .padding(horizontal = padding),
                onClick = { onNavigate(DependentPreferencesScreenKey) }
            ) {
                Text(text = "Dependent Preferences")
            }
        }
    }

}