import kotlin.math.max

fun resourceLines(resourceName: String) =
    object {}::class.java.getResource(resourceName)!!.readText().lines()

val <T> List<T>.head: T
    get() = first()

val <T> List<T>.tail: List<T>
    get() = drop(1)

fun <T> List<List<T>>.transpose(): List<List<T>> {
    val start = IntRange(0, max(size, first().size).dec()).map { emptyList<T>() }
    return fold(start) { acc, lst -> acc.zip(lst).map { it.first + listOf(it.second) } }
}
