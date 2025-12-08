package cz.eidam.material_preferences.core.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object Icons {

    val ArrowDropDown: ImageVector
        get() {
            if (_arrowDropDown != null) return _arrowDropDown!!

            _arrowDropDown = ImageVector.Builder(
                name = "arrowDropDown24dpE3E3E3FILL0Wght400GRAD0Opsz24",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 960f,
                viewportHeight = 960f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFFe3e3e3))
                ) {
                    moveTo(480f, 600f)
                    lineTo(280f, 400f)
                    horizontalLineToRelative(400f)
                    lineTo(480f, 600f)
                    close()
                }
            }.build()

            return _arrowDropDown!!
        }
    private var _arrowDropDown: ImageVector? = null

}