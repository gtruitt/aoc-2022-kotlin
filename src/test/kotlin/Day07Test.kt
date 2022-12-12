import day07.sumOfEligibleDirectories
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day07Test {
    @Test
    fun `provides sum of directories with size 100000 or less`() {
        sumOfEligibleDirectories(resourceLines("Day07.txt"), 100000) shouldBe 1454188
    }
}
