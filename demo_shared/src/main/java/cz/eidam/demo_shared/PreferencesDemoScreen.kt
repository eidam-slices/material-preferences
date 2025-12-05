package cz.eidam.demo_shared

import androidx.compose.foundation.layout.Column
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
import cz.eidam.material_preferences.core.dsl.*
import cz.eidam.material_preferences.core.ui.Preferences

const val PreferencesScreenKey = "preferences_demo"

@Composable
fun PreferencesDemoScreen(
    modifier: Modifier = Modifier,
    onGoToReading: () -> Unit = { },
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


        Button(
            modifier = Modifier.padding(16.dp),
            onClick = onGoToReading
        ) {
            Text(text = "Go to Reading Values")
        }
    }

}