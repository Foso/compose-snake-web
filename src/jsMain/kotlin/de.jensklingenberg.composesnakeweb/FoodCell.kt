package de.jensklingenberg.composesnakeweb

import androidx.compose.runtime.Composable
import androidx.compose.web.attributes.InputType
import androidx.compose.web.attributes.checked
import androidx.compose.web.elements.Input
import kotlinx.browser.document
import org.jetbrains.compose.common.ui.Modifier
import org.w3c.dom.events.KeyboardEvent

@Composable
fun FoodCell() {
    RadioButton(
        selected = true
    )
}

@Composable
fun RadioButton(selected: Boolean) {
        Input(
            type = InputType.Radio,
            attrs = {
                checked(selected)
                onCheckboxInput {}
            }
        ) {}
}

@Composable
fun EmptyCell() {
    Input(
        type = InputType.Checkbox
    ) {}
}

@Composable
fun SnakeCell() {
    Checkbox(true)
}

@Composable
fun Checkbox(selected: Boolean) {
    Input(
        type = InputType.Checkbox,
        attrs = {

            checked(selected)
            onCheckboxInput {}
        }
    ) {}
}


fun Modifier.onKeyEvent(listener: (KeyboardEvent) -> Unit): Modifier {
    document.addEventListener("keydown", { event ->
        val eve = (event as KeyboardEvent)
        listener(eve)
    })

    return this
}