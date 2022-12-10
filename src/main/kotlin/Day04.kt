@file:Suppress("PackageDirectoryMismatch")
package day04

fun assignmentPairToRangePair(assignmentPair: String) =
    assignmentPair
        .split(',', '-')
        .zipWithNext()
        .map { IntRange(it.first.toInt(), it.second.toInt()) }
        .let { Pair(it.first(), it.last()) }

fun IntRange.contains(other: IntRange) = first <= other.first && last >= other.last

fun fullyOverlappingPairCount(assignmentPairs: List<String>) =
    assignmentPairs
        .filter { it.isNotEmpty() }
        .map { assignmentPairToRangePair(it) }
        .count { it.first.contains(it.second) || it.second.contains(it.first) }

fun IntRange.overlaps(other: IntRange) = this.toSet().intersect(other.toSet()).any()

fun overlappingPairCount(assignmentPairs: List<String>) =
    assignmentPairs
        .filter { it.isNotEmpty() }
        .map { assignmentPairToRangePair(it) }
        .count { it.first.overlaps(it.second) }
