import day06.lengthAtFirstUniqueWindow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day06Test {
    @Test
    fun `tells us how many characters are before the first start-of-packet`() {
        lengthAtFirstUniqueWindow(resourceLines("Day06.txt").first(), 4) shouldBe 1300
    }

    @Test
    fun `tells us how many characters are before the first start-of-message`() {
        lengthAtFirstUniqueWindow(resourceLines("Day06.txt").first(), 14) shouldBe 3986
    }
}
