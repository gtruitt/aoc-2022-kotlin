@file:Suppress("PackageDirectoryMismatch")

package day08

import head

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

fun visibleTreeCount(input: List<String>): Int {
    val forest = readForest(input)
    return (0..forest.size.dec())
        .flatMap { x ->
            (0..forest.head.size.dec())
                .map { y ->
                    isVisible(x, y, forest)
                }
        }
        .count { it }
}
