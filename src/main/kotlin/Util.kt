fun resourceLines(resourceName: String) =
    object {}::class.java.getResource(resourceName)!!.readText().lines()

val <T> List<T>.head: T
    get() = first()

val <T> List<T>.tail: List<T>
    get() = drop(1)

fun <T> List<List<T>>.transpose(): List<List<T>> {
    val start = IntRange(0, size.dec()).map { emptyList<T>() }
    return fold(start) { acc, ints -> acc.zip(ints).map { it.first + listOf(it.second) } }
}
