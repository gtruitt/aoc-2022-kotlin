@file:Suppress("PackageDirectoryMismatch")

package day07

import head
import tail

const val TOKEN_SEP = " "
const val PROMPT = "$"
const val CD = "cd"
const val PATH_SEP = "/"
const val PREV_DIR = ".."
val filePattern = Regex("""\d+""")

val String.tokens get() = split(TOKEN_SEP)
val String.isCd get() = tokens.component1() == PROMPT && tokens.component2() == CD
val String.isFile get() = tokens.component1().matches(filePattern)
val String.fileSize get() = tokens.component1().toInt()

fun String.doCd(cmd: String) =
    when (cmd.tokens.component3()) {
        PREV_DIR -> split(PATH_SEP).dropLast(1).joinToString(PATH_SEP)
        else -> split(PATH_SEP).plus(cmd.tokens.component3()).joinToString(PATH_SEP)
    }

fun Map<String, Int>.sumOrSet(key: String, value: Int) =
    plus(key to getOrDefault(key, 0).plus(value))

tailrec fun readTerm(
    lines: List<String>,
    currentPath: String = "",
    pathSizes: Map<String, Int> = emptyMap()
): Map<String, Int> {
    val newPath = when (lines.head.isCd) {
        true -> currentPath.doCd(lines.head)
        false -> currentPath
    }
    return when {
        lines.tail.isEmpty() -> pathSizes
        lines.head.isCd -> readTerm(lines.tail, newPath, pathSizes.sumOrSet(newPath, 0))
        lines.head.isFile -> readTerm(lines.tail, newPath, pathSizes.sumOrSet(newPath, lines.head.fileSize))
        else -> readTerm(lines.tail, currentPath, pathSizes)
    }
}

fun Map<String, Int>.rollUpDirectorySizes() =
    keys.fold(this) { acc, key ->
        acc.plus(key to acc.filter { it.key.startsWith(key) }.values.sum())
    }

fun sumOfEligibleDirectories(terminalOutput: List<String>, maxSize: Int) =
    readTerm(terminalOutput)
        .rollUpDirectorySizes()
        .filter { it.value <= maxSize }
        .values
        .sum()
