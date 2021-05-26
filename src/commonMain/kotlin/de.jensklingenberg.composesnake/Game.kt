package de.jensklingenberg.composesnake

import androidx.compose.runtime.State
import de.jensklingenberg.composesnake.Board
import de.jensklingenberg.composesnake.Direction

interface Game {

    val board: State<Board>

    fun step()

    fun setDirection(direction: Direction)
}

