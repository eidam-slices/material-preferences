package cz.eidam.material_preferences.core.dsl

import androidx.annotation.StringRes
import cz.eidam.material_preferences.choice.model.ChoicePreference
import cz.eidam.material_preferences.core.model.Text

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
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue,
        entries = entries.map { Text(it)!! },
        entryValues = entryValues
    )
}

// String Resource / String Overload
fun PreferenceScope.choice(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int? = null,
    defaultValue: String,
    @StringRes entries: List<Int>,
    entryValues: List<String>,
) = add {
    ChoicePreference(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue,
        entries = entries.map { Text(it)!! },
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
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue.name,
        entries = entries.map { Text(it)!! },
        entryValues = entryValues.map { it.name }
    )
}

// String Resource / Enum Overload
fun <E: Enum<E>> PreferenceScope.enumChoice(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int? = null,
    defaultValue: E,
    @StringRes entries: List<Int>,
    entryValues: List<E>,
) = add {
    ChoicePreference(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue.name,
        entries = entries.map { Text(it)!! },
        entryValues = entryValues.map { it.name }
    )
}