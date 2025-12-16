package cz.eidam.material_preferences.core.dsl

import cz.eidam.material_preferences.choice.model.ChoicePreference
import cz.eidam.material_preferences.core.model.ChoiceItem

// String / String / Lists Overload
fun PreferenceScope.choice(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: String,
    entries: List<String>,
    entryValues: List<String>,
) = add {
    ChoicePreference(
        key = key,
        title = title,
        description = description,
        defaultValue = defaultValue,
        choices = entries.zip(entryValues).map { (label, value) ->
            ChoiceItem(label, value)
        }
    )
}

// String / Enum / Lists Overload
fun <E: Enum<E>> PreferenceScope.enumChoice(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: E,
    entries: List<String>,
    entryValues: List<E>,
) = add {
    ChoicePreference(
        key = key,
        title = title,
        description = description,
        defaultValue = defaultValue.name,
        choices = entries.zip(entryValues).map { (label, value) ->
            ChoiceItem(label, value.name)
        }
    )
}