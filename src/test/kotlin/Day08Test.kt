import day08.visibleTreeCount
import day08.maxScenicScore
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day08Test {
    @Test
    fun `counts trees visible from outside the forest`() {
        visibleTreeCount(resourceLines("Day08.txt")) shouldBe 1812
    }

    @Test
    fun `determines max scenic score of any tree in the forest`() {
        maxScenicScore(resourceLines("Day08.txt")) shouldBe 315495
    }
}
