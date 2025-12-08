package cz.eidam.material_preferences.multichoice.ui

import androidx.compose.foundation.BasicTooltipBox
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberBasicTooltipState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupPositionProvider

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreferenceTooltip(
    modifier: Modifier = Modifier,
    tooltip: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {

    BasicTooltipBox(
        modifier = modifier,
        state = rememberBasicTooltipState(),
        positionProvider = aboveStartPositionProvider(),
        tooltip = {
            Surface(
                shape = androidx.compose.material3.MaterialTheme.shapes.extraSmall,
                color = androidx.compose.material3.MaterialTheme.colorScheme.inverseSurface,
            ) {
                Box(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                    content = { tooltip() },
                )
            }
        },
        content = content,
    )
}

private fun aboveStartPositionProvider() = object: PopupPositionProvider {
    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize
    ): IntOffset {
        val x = anchorBounds.left
        val y = anchorBounds.top - popupContentSize.height
        return IntOffset(x, y)
    }
}