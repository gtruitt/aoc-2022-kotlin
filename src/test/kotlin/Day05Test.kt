import day05.CrateMoverModel
import day05.topsOfStacks
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day05Test {
    @Test
    fun `generates string of the top crates on the stacks, assuming CrateMover 9000`() {
        topsOfStacks(resourceLines("Day05.txt"), CrateMoverModel.CM9000) shouldBe "QMBMJDFTD"
    }

    @Test
    fun `generates string of the top crates on the stacks, assuming CrateMover 9001`() {
        topsOfStacks(resourceLines("Day05.txt"), CrateMoverModel.CM9001) shouldBe "NBTVTJNFJ"
    }
}
