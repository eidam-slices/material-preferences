package cz.eidam.demo_shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.eidam.material_preferences.Preferences

const val ReadingPreferencesScreenKey = "reading_preferences_demo"

@Composable
fun ReadingPreferencesDemoScreen(
    preferences: Preferences,
    modifier: Modifier = Modifier,
    onGoBack: () -> Unit = { },
) {


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                modifier = Modifier.padding(8.dp),
                text = "Reading Preferences Demo",
                style = MaterialTheme.typography.headlineMedium
            )

            ValueItem(
                key = PreferenceKeys.EXAMPLE_SWITCH,
                value = preferences.getBooleanState(
                    key = PreferenceKeys.EXAMPLE_SWITCH,
                    defaultValue = false
                ).value.toString(),
            )
            ValueItem(
                key = PreferenceKeys.EXAMPLE_SLIDER,
                value = preferences.getFloatState(
                    key = PreferenceKeys.EXAMPLE_SLIDER,
                    defaultValue = 67f
                ).value.toString(),
            )
            ValueItem(
                key = PreferenceKeys.EXAMPLE_RANGE_SLIDER,
                value = preferences.getFloatRangeState(
                    key = PreferenceKeys.EXAMPLE_RANGE_SLIDER,
                    defaultValue = 0f..100f
                ).value.toString(),
            )
            ValueItem(
                key = PreferenceKeys.EXAMPLE_CHOICE,
                value = preferences.getStringState(
                    key = PreferenceKeys.EXAMPLE_CHOICE,
                    defaultValue = "default"
                ).value.toString(),
            )
            ValueItem(
                key = PreferenceKeys.EXAMPLE_MULTI_CHOICE,
                value = preferences.getStringSetState(
                    key = PreferenceKeys.EXAMPLE_MULTI_CHOICE,
                    defaultValue = setOf("default1", "default2")
                ).value.toString(),
            )
            ValueItem(
                key = PreferenceKeys.EXAMPLE_TEXT_FIELD,
                value = preferences.getStringState(
                    key = PreferenceKeys.EXAMPLE_TEXT_FIELD,
                    defaultValue = "default"
                ).value.toString(),
            )
            ValueItem(
                key = PreferenceKeys.EXAMPLE_INLINE_TEXT_FIELD,
                value = preferences.getStringState(
                    key = PreferenceKeys.EXAMPLE_INLINE_TEXT_FIELD,
                    defaultValue = "default"
                ).value.toString(),
            )
        }

        Button(
            modifier = Modifier.padding(16.dp),
            onClick = onGoBack
        ) {
            Text("Go back")
        }

    }


}


@Composable
fun ValueItem(
    key: String,
    value: String,
    modifier: Modifier = Modifier
) {

    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(
                text = "'$key'"
            )
        },
        supportingContent = {
            Text(
                text = value
            )
        }
    )

}