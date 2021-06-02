package de.jensklingenberg.composesnake.ui

import androidx.compose.runtime.Composable
import de.jensklingenberg.composesnake.Board
import org.jetbrains.compose.common.foundation.layout.Column
import org.jetbrains.compose.common.foundation.layout.Row
import org.jetbrains.compose.common.material.Text

@Composable
fun Board(board: Board) {
    if (board.snake == null) {
        Text(
            text = "Game over!"
        )
        return
    }

    Column {
        board.grid.forEach { row ->
            Row {
                row.forEach { cell ->
                    when (cell) {
                        board.food -> FoodCell()
                        in board.snake.points -> SnakeCell()
                        else -> EmptyCell()
                    }
                }
            }
        }
    }
}

expect fun FoodCell()

expect fun SnakeCell()

expect fun EmptyCell()