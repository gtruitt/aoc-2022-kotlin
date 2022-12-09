import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day02Test {
    @Test
    fun `total score of elf strategy guide`() {
        totalScore(resourceLines("Day02.txt")) shouldBe 12156
    }

    @Test
    fun `revised total score of elf strategy guide`() {
        revisedTotalScore(resourceLines("Day02.txt")) shouldBe 10835
    }
}
