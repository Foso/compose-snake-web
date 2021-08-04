package de.jensklingenberg.composesnake.ui

import androidx.compose.runtime.Composable
import de.jensklingenberg.composesnakeweb.Checkbox
import de.jensklingenberg.composesnakeweb.RadioButton
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.Input


@Composable
actual fun FoodCell() {
    RadioButton(
    )
}

@Composable
actual fun SnakeCell() {
    Checkbox()
}

@Composable
actual fun EmptyCell() {
    Input(
        type = InputType.Checkbox
    ) {}
}