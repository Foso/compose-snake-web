package de.jensklingenberg.composesnakeweb

import androidx.compose.runtime.Composable
import kotlinx.browser.document
import org.jetbrains.compose.common.ui.ExperimentalComposeWebWidgetsApi
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.attributes.InputType

import org.jetbrains.compose.web.dom.Input
import org.w3c.dom.events.KeyboardEvent


@Composable
fun RadioButton() {
        Input(
            type = InputType.Radio,
            attrs = {
                this.checked(true)
            }
        )
}





@Composable
fun Checkbox() {
    Input(
        type = InputType.Checkbox,
        attrs = {
            this.checked(true)
        }
    )
}


@OptIn(ExperimentalComposeWebWidgetsApi::class)
fun Modifier.onKeyEvent(listener: (KeyboardEvent) -> Unit): Modifier {
    document.addEventListener("keydown", { event ->
        val eve = (event as KeyboardEvent)
        listener(eve)
    })

    return this
}