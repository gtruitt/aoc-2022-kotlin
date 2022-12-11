@file:Suppress("PackageDirectoryMismatch")
package day01

import kotlin.math.max
import head
import tail

tailrec fun sumTopTotals(
    foodItems: List<String>,
    topCount: Int,
    currentTotal: Int = 0,
    totals: List<Int> = emptyList()
): Int =
    when {
        foodItems.tail.isEmpty() -> totals.sorted().reversed().take(topCount).sum()
        foodItems.head.isEmpty() -> sumTopTotals(foodItems.tail, topCount, 0, totals + listOf(currentTotal))
        else -> sumTopTotals(foodItems.tail, topCount, currentTotal + foodItems.head.toInt(), totals)
    }
