package cz.eidam.material_preferences.core.dsl

import androidx.annotation.StringRes
import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.multichoice.model.MultiChoicePreference

// String title / String type / Custom Overload
fun PreferenceScope.multiChoice(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: Set<String>,
    entries: List<String>,
    entryValues: List<String>,
    valueFormatter: (List<String>) -> String,
) = add {
    MultiChoicePreference.Custom(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue,
        entries = entries.map { Text(it)!! },
        entryValues = entryValues,
        valueFormatter = valueFormatter,
    )
}

// String Resource title / String type / Custom Overload
fun PreferenceScope.multiChoice(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int? = null,
    defaultValue: Set<String>,
    @StringRes entries: List<Int>,
    entryValues: List<String>,
    valueFormatter: (List<String>) -> String,
) = add {
    MultiChoicePreference.Custom(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue,
        entries = entries.map { Text(it)!! },
        entryValues = entryValues,
        valueFormatter = valueFormatter,
    )
}

// String title / String type / Default Overload
fun PreferenceScope.multiChoice(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: Set<String>,
    entries: List<String>,
    entryValues: List<String>,
) = add {
    MultiChoicePreference.Default(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue,
        entries = entries.map { Text(it)!! },
        entryValues = entryValues,
    )
}

// String Resource title / String type / Default Overload
fun PreferenceScope.multiChoice(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int? = null,
    defaultValue: Set<String>,
    @StringRes entries: List<Int>,
    entryValues: List<String>,
) = add {
    MultiChoicePreference.Default(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue,
        entries = entries.map { Text(it)!! },
        entryValues = entryValues,
    )
}


// String / Enum / Custom Overload
fun <E: Enum<E>> PreferenceScope.enumMultiChoice(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: Set<E>,
    entries: List<String>,
    entryValues: List<E>,
    valueFormatter: (List<String>) -> String,
) = add {
    MultiChoicePreference.Custom(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue.map { it.name }.toSet(),
        entries = entries.map { Text(it)!! },
        entryValues = entryValues.map { it.name },
        valueFormatter = valueFormatter
    )
}

// String Resource / Enum / Custom Overload
fun <E: Enum<E>> PreferenceScope.enumMultiChoice(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int? = null,
    defaultValue: Set<E>,
    @StringRes entries: List<Int>,
    entryValues: List<E>,
    valueFormatter: (List<String>) -> String
) = add {
    MultiChoicePreference.Custom(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue.map { it.name }.toSet(),
        entries = entries.map { Text(it)!! },
        entryValues = entryValues.map { it.name },
        valueFormatter = valueFormatter
    )
}

// String / Enum / Default Overload
fun <E: Enum<E>> PreferenceScope.enumMultiChoice(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: Set<E>,
    entries: List<String>,
    entryValues: List<E>,
) = add {
    MultiChoicePreference.Default(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue.map { it.name }.toSet(),
        entries = entries.map { Text(it)!! },
        entryValues = entryValues.map { it.name },
    )
}

// String Resource / Enum / Default Overload
fun <E: Enum<E>> PreferenceScope.enumMultiChoice(
    key: String,
    @StringRes title: Int,
    @StringRes description: Int? = null,
    defaultValue: Set<E>,
    @StringRes entries: List<Int>,
    entryValues: List<E>,
) = add {
    MultiChoicePreference.Default(
        key = key,
        title = Text(title)!!,
        description = Text(description),
        defaultValue = defaultValue.map { it.name }.toSet(),
        entries = entries.map { Text(it)!! },
        entryValues = entryValues.map { it.name },
    )
}