package cz.eidam.material_preferences.category.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun PreferenceCategory(
    title: String? = null,
    expanded: Boolean? = null,
    onExpandedChange: ((Boolean) -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {

    val titleSet = title != null // && title.isNotBlank()

    val padding = if (titleSet) PaddingValues(start = 16.dp, end = 0.dp)
    else PaddingValues(all = 0.dp)


    Column {
        if (titleSet) {
            CategoryTitle(
                title = title,
                expanded = expanded,
                modifier = Modifier
                    .clickable(
                        enabled = expanded != null && onExpandedChange != null,
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = expanded?.let { expanded ->
                            onExpandedChange?.let { { it.invoke(!expanded) } }
                        } ?: { }
                    )
            )
        }
        AnimatedVisibility(
            visible = expanded ?: true
        ) {
            Column(
                modifier = Modifier.padding(padding),
                content = content
            )
        }

        HorizontalDivider(Modifier.padding(horizontal = 12.dp))

    }

}