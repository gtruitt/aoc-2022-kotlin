import day01.highestTotal
import day01.sumTopTotals
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day01Test {
    @Test
    fun `highest single-elf calorie total`() {
        highestTotal(resourceLines("Day01.txt")) shouldBe 71023
    }

    @Test
    fun `sum of n highest single-elf calorie totals`() {
        sumTopTotals(resourceLines("Day01.txt"), 1) shouldBe 71023
        sumTopTotals(resourceLines("Day01.txt"), 3) shouldBe 206289
    }
}
