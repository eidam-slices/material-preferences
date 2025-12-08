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

data class TextFieldDialogProperties(
    override val title: String,
    override val confirmText: String,
    override val cancelText: String,
    val label: String?,
    val placeholder: String?,
): PreferenceDialogProperties(title, confirmText, cancelText) {


    companion object {
        @Composable
        fun default(title: String) = TextFieldDialogProperties(
            title = title,
            confirmText = stringResource(android.R.string.ok),
            cancelText = stringResource(android.R.string.cancel),
            label = null,
            placeholder = null
        )
    }
}