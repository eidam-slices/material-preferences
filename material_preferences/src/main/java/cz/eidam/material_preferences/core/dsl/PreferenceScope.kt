package cz.eidam.material_preferences.core.dsl

import cz.eidam.material_preferences.generic.model.PreferenceRow

open class PreferenceScope {

    // make this protected if needed (e.g. adding rows via categories, ...)
    private val _all = mutableListOf<PreferenceRow>()
    val all: List<PreferenceRow> get() = _all

    // ? TODO: make internal ?
    fun add(row: () -> PreferenceRow) { _all.add(row()) }
}