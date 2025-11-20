package cz.eidam.material_preferences.generic.model

import cz.eidam.material_preferences.generic.model.PreferenceRow
import cz.eidam.material_preferences.core.model.Text

abstract class Preference: PreferenceRow {
    abstract val key: String
    abstract val title: Text
    abstract val description: Text?
    abstract val defaultValue: Any
}