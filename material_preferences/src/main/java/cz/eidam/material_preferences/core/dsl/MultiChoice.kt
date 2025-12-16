package cz.eidam.material_preferences.core.dsl

import cz.eidam.material_preferences.multichoice.model.MultiChoicePreference

// String title / String type / Custom Overload
fun PreferenceScope.multiChoice(
    key: String,
    title: String,
    description: String? = null,
    defaultValue: Set<String>,
    entries: List<String>,
    entryValues: List<String>,
    tooltipEnabled: Boolean = true,
    valueFormatter: (List<String>) -> String,
) = add {
    MultiChoicePreference.Custom(
        key = key,
        title = title,
        description = description,
        defaultValue = defaultValue,
        entries = entries,
        entryValues = entryValues,
        tooltipEnabled = tooltipEnabled,
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
        title = title,
        description = description,
        defaultValue = defaultValue,
        entries = entries,
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
    tooltipEnabled: Boolean = true,
    valueFormatter: (List<String>) -> String,
) = add {
    MultiChoicePreference.Custom(
        key = key,
        title = title,
        description = description,
        defaultValue = defaultValue.map { it.name }.toSet(),
        entries = entries,
        entryValues = entryValues.map { it.name },
        tooltipEnabled = tooltipEnabled,
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
        title = title,
        description = description,
        defaultValue = defaultValue.map { it.name }.toSet(),
        entries = entries,
        entryValues = entryValues.map { it.name },
    )
}