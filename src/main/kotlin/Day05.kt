@file:Suppress("PackageDirectoryMismatch")
package day05

import head
import tail
import transpose

fun List<String>.parseCrates(): List<List<Char>> =
    map { line -> line.filterIndexed { i, _ -> i.dec().mod(4) == 0 }.toList() }
        .transpose()
        .map { it.filterNot { it.isWhitespace() } }

val moveRegex = Regex("""move (\d+) from (\d+) to (\d+)""")

data class MoveInstruction(val n: Int, val fromIndex: Int, val toIndex: Int)

fun String.toMoveInstruction() =
    moveRegex.find(this)!!
        .groupValues
        .tail
        .let {
            MoveInstruction(
                it.component1().toInt(),
                it.component2().toInt().dec(),
                it.component3().toInt().dec()
            )
        }

enum class CrateMoverModel {
    CM9000,
    CM9001
}

fun List<Char>.movedBy(model: CrateMoverModel) =
    when (model) {
        CrateMoverModel.CM9000 -> this.reversed()
        CrateMoverModel.CM9001 -> this
    }

fun List<List<Char>>.applyMove(move: MoveInstruction, model: CrateMoverModel) =
    mapIndexed { index, stack ->
        when (index) {
            move.fromIndex -> stack.drop(move.n)
            move.toIndex -> this[move.fromIndex].take(move.n).movedBy(model) + stack
            else -> stack
        }
    }

fun topsOfStacks(instructions: List<String>, model: CrateMoverModel): String {
    val firstBlankIndex = instructions.indexOfFirst { it.isEmpty() }
    val crates = instructions.subList(0, firstBlankIndex.dec()).parseCrates()
    return instructions
        .subList(firstBlankIndex.inc(), instructions.lastIndex)
        .map { it.toMoveInstruction() }
        .fold(crates) { acc, move -> acc.applyMove(move, model) }
        .map { it.head }
        .joinToString("")
}
