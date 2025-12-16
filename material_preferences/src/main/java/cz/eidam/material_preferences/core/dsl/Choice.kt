package cz.eidam.material_preferences.core.dsl

import cz.eidam.material_preferences.choice.model.ChoicePreference

// String / String Overload
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
        entries = entries,
        entryValues = entryValues
    )
}

// String / Enum Overload
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
        entries = entries,
        entryValues = entryValues.map { it.name }
    )
}