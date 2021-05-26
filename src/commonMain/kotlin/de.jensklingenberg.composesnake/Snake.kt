package de.jensklingenberg.composesnake

import de.jensklingenberg.composesnake.Point

data class Snake(
    val points: Set<Point>,
    val head: Point
)
