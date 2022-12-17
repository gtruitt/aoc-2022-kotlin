@file:Suppress("PackageDirectoryMismatch")

package day08

import head
import tail

fun readForest(input: List<String>) =
    input
        .filter { it.isNotEmpty() }
        .map { trees ->
            trees.toCharArray().map { it.digitToInt() }
        }

fun isVisible(x: Int, y: Int, forest: List<List<Int>>) =
    x == 0
    || y == 0
    || x == forest.size.dec()
    || y == forest.head.size.dec()
    || (0..x.dec()).none { forest[it][y] >= forest[x][y] }
    || (x.inc()..forest.size.dec()).none { forest[it][y] >= forest[x][y] }
    || (0..y.dec()).none { forest[x][it] >= forest[x][y] }
    || (y.inc()..forest.head.size.dec()).none { forest[x][it] >= forest[x][y] }

fun visibleTreeCount(input: List<String>) =
    readForest(input).let { forest ->
        (forest.indices).flatMap { x ->
            (forest.head.indices).map { y ->
                isVisible(x, y, forest)
            }
        }.count { it }
    }

tailrec fun visibleTreeCount(myHeight: Int, trees: List<Int>, count: Int = 0): Int =
    when {
        trees.isEmpty() -> count
        trees.head >= myHeight -> count.inc()
        else -> visibleTreeCount(myHeight, trees.tail, count.inc())
    }

fun toTheLeft(x: Int, y: Int, forest: List<List<Int>>) =
    (x.dec() downTo 0).map { forest[it][y] }

fun toTheRight(x: Int, y: Int, forest: List<List<Int>>) =
    (x.inc() until forest.size).map { forest[it][y] }

fun toTheTop(x: Int, y: Int, forest: List<List<Int>>) =
    (y.inc() until forest.head.size).map { forest[x][it] }

fun toTheBottom(x: Int, y: Int, forest: List<List<Int>>) =
    (y.dec() downTo 0).map { forest[x][it] }

fun scenicScore(x: Int, y: Int, forest: List<List<Int>>) =
    listOf(::toTheLeft, ::toTheRight, ::toTheTop, ::toTheBottom)
        .map {
            visibleTreeCount(forest[x][y], it(x, y, forest))
        }
        .reduce { acc, it -> acc * it }

fun maxScenicScore(input: List<String>) =
    readForest(input).let { forest ->
        (forest.indices).flatMap { x ->
            (forest.head.indices).map { y ->
                scenicScore(x, y, forest)
            }
        }.max()
    }
