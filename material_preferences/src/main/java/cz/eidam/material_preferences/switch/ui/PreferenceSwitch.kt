package cz.eidam.material_preferences.switch.ui

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import cz.eidam.material_preferences.generic.ui.PreferenceRow

@Composable
fun PreferenceSwitch(
    title: String,
    description: String? = null,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {

    PreferenceRow(
        title = title,
        description = description
    ) {
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }

}