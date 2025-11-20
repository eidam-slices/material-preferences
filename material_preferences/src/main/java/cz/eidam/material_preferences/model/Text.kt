package cz.eidam.material_preferences.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class Text {
    @Composable
    abstract fun value(): String

    data class Resource(@param:StringRes val id: Int): Text() {
        @Composable
        override fun value() = stringResource(id)
    }

    data class Plain(val text: String): Text() {
        @Composable
        override fun value(): String = text
    }

    companion object {
        operator fun invoke(text: String?) = text?.let { Plain(it) }
        operator fun invoke(@StringRes id: Int?) = id?.let { Resource(it) }
    }
}