package cz.eidam.material_preferences.core.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

open class PreferenceDialogProperties(
    open val title: String,
    open val confirmText: String,
    open val cancelText: String
) {

    companion object {
        @Composable
        fun default(title: String): PreferenceDialogProperties {
            return PreferenceDialogProperties(
                title = title,
                confirmText = stringResource(android.R.string.ok),
                cancelText = stringResource(android.R.string.cancel),
            )
        }
    }
}