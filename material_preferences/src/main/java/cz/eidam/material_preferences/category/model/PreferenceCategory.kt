package cz.eidam.material_preferences.category.model

import androidx.compose.runtime.Composable
import cz.eidam.material_preferences.core.dsl.PreferenceScope
import cz.eidam.material_preferences.core.model.Text
import cz.eidam.material_preferences.generic.model.PreferenceRow

data class PreferenceCategory(
    val title: Text?,
    val collapsible: Boolean,
    val content: @Composable PreferenceScope.() -> Unit
): PreferenceRow