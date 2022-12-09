fun resourceLines(resourceName: String) =
    object {}::class.java.getResource(resourceName)!!.readText().lines()

val <T> List<T>.head: T
    get() = first()

val <T> List<T>.tail: List<T>
    get() = drop(1)
