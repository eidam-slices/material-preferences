package cz.eidam.material_preferences.generic.model


abstract class Preference: PreferenceRow {
    abstract val key: String
    abstract val title: String
    abstract val description: String?
    abstract val defaultValue: Any
}