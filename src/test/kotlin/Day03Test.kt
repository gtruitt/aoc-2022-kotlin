import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day03Test {
    @Test
    fun `yields correct priority per character bound`() {
        'a'.priority shouldBe 1
        'z'.priority shouldBe 26
        'A'.priority shouldBe 27
        'Z'.priority shouldBe 52
    }

    @Test
    fun `sum of priorities of misplaced items`() {
        sumOfMisplacedPriorities(resourceLines("Day03.txt")) shouldBe 8123
    }

    @Test
    fun `sum of priorities of badges`() {
        sumOfBadgePriorities(resourceLines("Day03.txt")) shouldBe 2620
    }
}
