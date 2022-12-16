import day08.visibleTreeCount
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day08Test {
    @Test
    fun `counts trees visible from outside the forest`() {
        visibleTreeCount(resourceLines("Day08.txt")) shouldBe 1812
    }
}
