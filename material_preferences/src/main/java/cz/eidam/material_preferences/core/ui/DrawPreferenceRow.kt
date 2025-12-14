package cz.eidam.material_preferences.core.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import cz.eidam.material_preferences.category.model.PreferenceCategory
import cz.eidam.material_preferences.choice.model.ChoicePreference
import cz.eidam.material_preferences.choice.ui.DataStorePreferenceChoice
import cz.eidam.material_preferences.generic.model.DependentPreference
import cz.eidam.material_preferences.generic.model.PreferenceRow
import cz.eidam.material_preferences.multichoice.model.MultiChoicePreference
import cz.eidam.material_preferences.multichoice.ui.DataStorePreferenceMultiChoice
import cz.eidam.material_preferences.multichoice.ui.MultiChoicePreferenceDefaults
import cz.eidam.material_preferences.rangeslider.model.RangeSliderPreference
import cz.eidam.material_preferences.rangeslider.ui.DataStorePreferenceRangeSlider
import cz.eidam.material_preferences.rangeslider.ui.RangeSliderPreferenceDefaults
import cz.eidam.material_preferences.slider.model.SliderPreference
import cz.eidam.material_preferences.slider.ui.DataStorePreferenceSlider
import cz.eidam.material_preferences.slider.ui.SliderPreferenceDefaults
import cz.eidam.material_preferences.switch.model.SwitchPreference
import cz.eidam.material_preferences.switch.ui.DataStorePreferenceSwitch
import cz.eidam.material_preferences.textfield.model.TextFieldPreference
import cz.eidam.material_preferences.textfield.ui.DataStorePreferenceTextField
import cz.eidam.material_preferences.textfield.ui.DataStorePreferenceTextFieldInline


@Composable
internal fun DrawPreferenceRow(
    preference: PreferenceRow,
    dataStore: DataStore<Preferences>,
) {
    when (val preference = preference) {
        is PreferenceCategory -> {
            DrawPreferenceCategory(preference, dataStore)
        }

        is DependentPreference<*> -> {
            Log.d("DrawPreferenceRow", "Drawing DependentPreference with key='${preference.dependencyKey}'")
            DrawDependentPreference(
                dependentPreference = preference,
                dataStore = dataStore
            )
        }

        is SwitchPreference -> {
            DataStorePreferenceSwitch(
                key = preference.key,
                title = preference.title.value(),
                description = preference.description?.value(),
                defaultValue = preference.defaultValue,
                dataStore = dataStore
            )
        }

        is SliderPreference -> {
            val formatter = when (val preference: SliderPreference = preference) {
                is SliderPreference.Custom -> preference.valueFormatter
                is SliderPreference.WithUnit -> SliderPreferenceDefaults.unitFormatter(
                    preference.step,
                    preference.unit
                )
            }

            DataStorePreferenceSlider(
                key = preference.key,
                title = preference.title.value(),
                description = preference.description?.value(),
                defaultValue = preference.defaultValue,
                valueRange = preference.valueRange,
                step = preference.step,
                transform = formatter,
                dataStore = dataStore
            )
        }

        is RangeSliderPreference -> {
            val transform = when (val preference: RangeSliderPreference = preference) {
                is RangeSliderPreference.Custom -> preference.transform
                is RangeSliderPreference.WithUnit -> RangeSliderPreferenceDefaults.unitFormatter(
                    preference.step,
                    preference.unit
                )
            }

            DataStorePreferenceRangeSlider(
                key = preference.key,
                title = preference.title.value(),
                description = preference.description?.value(),
                defaultValue = preference.defaultValue,
                valueRange = preference.valueRange,
                step = preference.step,
                transform = transform,
                dataStore = dataStore
            )
        }

        is ChoicePreference -> {
            DataStorePreferenceChoice(
                key = preference.key,
                title = preference.title.value(),
                description = preference.description?.value(),
                entries = preference.entries.map { it.value() },
                entryValues = preference.entryValues,
                defaultValue = preference.defaultValue,
                dataStore = dataStore
            )
        }

        is MultiChoicePreference -> {
            val formatter = when (val preference: MultiChoicePreference = preference) {
                is MultiChoicePreference.Custom -> preference.valueFormatter
                is MultiChoicePreference.Default -> MultiChoicePreferenceDefaults.formatter()
            }

            DataStorePreferenceMultiChoice(
                key = preference.key,
                title = preference.title.value(),
                description = preference.description?.value(),
                entries = preference.entries.map { it.value() },
                entryValues = preference.entryValues,
                defaultValue = preference.defaultValue,
                tooltipEnabled = when (val preference: MultiChoicePreference = preference) {
                    is MultiChoicePreference.Custom -> preference.tooltipEnabled
                    is MultiChoicePreference.Default -> true
                },
                valueDisplayFormatter = formatter,
                dataStore = dataStore,
            )
        }

        is TextFieldPreference.Modal -> {
            DataStorePreferenceTextField(
                key = preference.key,
                title = preference.title.value(),
                description = preference.description?.value(),
                defaultValue = preference.defaultValue,
                dataStore = dataStore
            )
        }

        is TextFieldPreference.Inline -> {
            DataStorePreferenceTextFieldInline(
                key = preference.key,
                title = preference.title.value(),
                description = preference.description?.value(),
                defaultValue = preference.defaultValue,
                dataStore = dataStore
            )
        }

        else -> Log.e(
            "DrawPreferenceRow",
            "Failed to draw PreferenceRow. Unsupported PreferenceRow type: $preference"
        )
    }
}