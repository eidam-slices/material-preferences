package cz.eidam.material_preferences.model

sealed class Preference: PreferenceRow {
    abstract val key: String
    abstract val title: Text
    abstract val description: Text?
    abstract val defaultValue: Any
}