package cz.eidam.material_preferences.category.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@Composable
fun CategoryTitle(
    title: String,
    expanded: Boolean?,
    modifier: Modifier = Modifier,
) {

    Row(
        modifier = modifier.padding(
            start = 16.dp, end = 8.dp,
            top = 8.dp, bottom = 8.dp,
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
        )

        Spacer(Modifier.weight(1f))

        expanded?.let { expanded ->
            val rotation by animateFloatAsState(targetValue = if (expanded) 0f else 180f)

            Icon(
                modifier = Modifier.rotate(rotation),
                // ? TODO: add support for different icon for expanded/collapsed state,
                //  if its possible to animate it
                imageVector = Icons.Rounded.ArrowDropDown,
                contentDescription = "TODO", // TODO: add content description
            )
        }
    }
}