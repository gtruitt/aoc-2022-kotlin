val Char.priority
    get() = when {
        isLowerCase() -> code - 96
        isUpperCase() -> code - 38
        else -> throw Exception("unrecognized character")
    }

val List<List<Char>>.intersections
    get() =
        this.map { it.toSet() }.reduce { acc, it -> acc.intersect(it) }

fun sumOfMisplacedPriorities(rucksacks: List<String>) =
    rucksacks
        .filter { it.isNotEmpty() }
        .sumOf { rucksack ->
            rucksack.chunked(rucksack.length / 2)
                .map { it.toList() }
                .intersections
                .sumOf { it.priority }
        }

fun sumOfBadgePriorities(rucksacks: List<String>) =
    rucksacks
        .chunked(3)
        .sumOf { group ->
            group.map { it.toList() }
                .intersections
                .sumOf { it.priority }
        }
