import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.w3c.dom.ranges.Range

class Day04Test {
    @Test
    fun `generates correct ranges from assignment description`() {
        assignmentPairToRangePair("2-4,6-8") shouldBe  Pair(IntRange(2, 4), IntRange(6, 8))
    }

    @Test
    fun `counts fully overlapping assignment pairs`() {
        fullyOverlappingPairCount(resourceLines("Day04.txt")) shouldBe 651
    }

    @Test
    fun `counts all overlapping assignment pairs`() {
        overlappingPairCount(resourceLines("Day04.txt")) shouldBe 956
    }
}
