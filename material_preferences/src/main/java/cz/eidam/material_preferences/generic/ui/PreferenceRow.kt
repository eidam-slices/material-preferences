package cz.eidam.material_preferences.generic.ui

import androidx.compose.foundation.combinedClickable
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PreferenceRow(
    title: String,
    description: String? = null,

    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,

    widget: (@Composable () -> Unit)? = null,
) {
    ListItem(
        modifier = Modifier.combinedClickable(
            enabled = onClick != null || onLongClick != null,
            onClick = onClick ?: {},
            onLongClick = onLongClick,
        ),
        headlineContent = { Text(title) },
        supportingContent = description?.let { { Text(it) } },
        trailingContent = widget
    )
}