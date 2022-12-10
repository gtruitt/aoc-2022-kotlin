import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class UtilTest {
    @Test
    fun `transposes a list of lists so the nth items from each become the nth transposed list`() {
        val initial = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
        val transposed = listOf(listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9))
        initial.transpose() shouldBe transposed
    }
}
