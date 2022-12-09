import kotlin.math.max

tailrec fun highestTotal(
    foodItems: List<String>,
    currentTotal: Int = 0,
    highestTotal: Int = 0): Int =
    when {
        foodItems.tail.isEmpty() -> highestTotal
        foodItems.head.isEmpty() -> highestTotal(foodItems.tail, 0, max(currentTotal, highestTotal))
        else -> highestTotal(foodItems.tail, currentTotal + foodItems.head.toInt(), highestTotal)
    }

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
