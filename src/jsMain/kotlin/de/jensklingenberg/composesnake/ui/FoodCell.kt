package de.jensklingenberg.composesnake.ui

import androidx.compose.runtime.Composable
import androidx.compose.web.attributes.InputType
import androidx.compose.web.elements.Input
import de.jensklingenberg.composesnakeweb.Checkbox
import de.jensklingenberg.composesnakeweb.RadioButton

@Composable
actual fun FoodCell() {
    RadioButton(
        selected = true
    )
}

@Composable
actual fun SnakeCell() {
    Checkbox(true)
}

@Composable
actual fun EmptyCell() {
    Input(
        type = InputType.Checkbox
    ) {}
}