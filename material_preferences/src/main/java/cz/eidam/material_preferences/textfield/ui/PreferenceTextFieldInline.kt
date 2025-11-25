package cz.eidam.material_preferences.textfield.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cz.eidam.material_preferences.generic.ui.PreferenceRow

@Composable
fun PreferenceTextFieldInline(
    title: String,
    description: String? = null,
    value: String,
    onValueChange: (String) -> Unit,
) {


    PreferenceRow(
        title = title,
        description = description,
        onClick = null,
    ) {

        Box(
            // TODO: extract this to constant for all preferences
            modifier = Modifier
                .widthIn(max = 128.dp),
        ) {

            if (value.isEmpty()) {
                BasicText(
                    text = "–",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    ),
                )
            }

            BasicTextField(
                modifier = Modifier
                    .width(IntrinsicSize.Max),
                value = value,
                maxLines = 2,
                onValueChange = onValueChange,
                textStyle = MaterialTheme.typography.titleMedium.copy(
                    textAlign = TextAlign.Center
                ),
            )
        }
    }
}