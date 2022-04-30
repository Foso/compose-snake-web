package com.arkivanov.composnake

import androidx.compose.runtime.LaunchedEffect

import de.jensklingenberg.composesnake.DefaultGame
import de.jensklingenberg.composesnake.Direction
import de.jensklingenberg.composesnake.Game
import de.jensklingenberg.composesnake.ui.Board
import de.jensklingenberg.composesnakeweb.onKeyEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.ui.ExperimentalComposeWebWidgetsApi
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
@OptIn(ExperimentalComposeWebWidgetsApi::class)

fun main() {
    val game: Game = DefaultGame()

    renderComposable(rootElementId = "root") {

        LaunchedEffect(Unit) {
            while (isActive) {
                delay(200L)
                game.step()
            }
        }

        Div(attrs = { style { padding(25.px) } }) {
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

