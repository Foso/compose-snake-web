package com.arkivanov.composnake

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.web.css.padding
import androidx.compose.web.css.px
import androidx.compose.web.elements.Div
import androidx.compose.web.elements.Text
import androidx.compose.web.renderComposable
import de.jensklingenberg.composesnakeweb.EmptyCell
import de.jensklingenberg.composesnakeweb.FoodCell
import de.jensklingenberg.composesnakeweb.SnakeCell
import de.jensklingenberg.composesnakeweb.onKeyEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.foundation.layout.Column
import org.jetbrains.compose.common.foundation.layout.Row
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.common.ui.Modifier

fun main() {
    val game: Game = DefaultGame()

    renderComposable(rootElementId = "root") {

        LaunchedEffect(Unit) {
            while (isActive) {
                delay(200L)
                game.step()
            }
        }

        Div(style = { padding(25.px) }) {
            Text("Points: "+game.board.value.points)

            Box(
                modifier = Modifier
                    .onKeyEvent {
                        when (it.key) {
                            "ArrowLeft" -> game.setDirection(Direction.LEFT).let { true }
                            "ArrowUp" -> game.setDirection(Direction.UP).let { true }
                            "ArrowRight" -> game.setDirection(Direction.RIGHT).let { true }
                            "ArrowDown" -> game.setDirection(Direction.DOWN).let { true }
                            else -> false
                        }
                    }
            ) {
                Board(game.board.value)
            }
        }
    }
}

@Composable
private fun Board(board: Board) {
    if (board.snake == null) {
        Text(
            text = "Game over!"
        )
        return
    }

    Column {
        board.grid.forEachFast { row ->
            Row {
                row.forEachFast { cell ->
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
