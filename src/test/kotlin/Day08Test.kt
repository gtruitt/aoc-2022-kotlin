import day08.visibleTreeCount
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day08Test {
    @Test
    fun `reads forest into 2D list`() {
        visibleTreeCount(resourceLines("Day08.txt")) shouldBe 1812
    }
}
