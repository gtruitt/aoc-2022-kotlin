import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class UtilTest {
    @Test
    fun `transposes square matrix`() {
        val initial = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
        val transposed = listOf(listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9))
        initial.transpose() shouldBe transposed
    }

    @Test
    fun `transposes x-rectangular matrix`() {
        val initial = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9), listOf(10, 11, 12))
        val transposed = listOf(listOf(1, 4, 7, 10), listOf(2, 5, 8, 11), listOf(3, 6, 9, 12))
        initial.transpose() shouldBe transposed
    }

    @Test
    fun `transposes y-rectangular matrix`() {
        val initial = listOf(listOf(1, 2, 3, 4), listOf(5, 6, 7, 8), listOf(9, 10, 11, 12))
        val transposed = listOf(listOf(1, 5, 9), listOf(2, 6, 10), listOf(3, 7, 11), listOf(4, 8, 12))
        initial.transpose() shouldBe transposed
    }
}
