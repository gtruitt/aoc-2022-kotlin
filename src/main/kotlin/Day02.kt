enum class Play(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
}

val Play.beats
    get() = when (this) {
        Play.ROCK -> Play.SCISSORS
        Play.PAPER -> Play.ROCK
        Play.SCISSORS -> Play.PAPER
    }

val Play.isBeatBy
    get() = when (this) {
        Play.ROCK -> Play.PAPER
        Play.PAPER -> Play.SCISSORS
        Play.SCISSORS -> Play.ROCK
    }

fun String.toPlay() = when (this) {
    in listOf("A", "X") -> Play.ROCK
    in listOf("B", "Y") -> Play.PAPER
    in listOf("C", "Z") -> Play.SCISSORS
    else -> throw Exception("unrecognized play")
}

data class GameRound(
    val opponent: Play,
    val mine: Play
)

fun String.toGameRound(): GameRound {
    val plays = this.split(" ").map { it.toPlay() }
    return GameRound(plays.first(), plays.last())
}

val GameRound.isWin get() = mine.beats == opponent
val GameRound.isDraw get() = opponent == mine
val GameRound.score
    get() = mine.score + when {
        isWin -> 6
        isDraw -> 3
        else -> 0
    }

fun totalScore(encryptedRounds: List<String>) =
    encryptedRounds.filter { it.isNotEmpty() }.sumOf { it.toGameRound().score }

// X = I lose, Y = draw, Z = I win
fun myPlay(theirPlay: Play, myEncryptedPlay: String) =
    when (myEncryptedPlay) {
        "X" -> theirPlay.beats
        "Y" -> theirPlay
        "Z" -> theirPlay.isBeatBy
        else -> throw Exception("unrecognized play")
    }

fun String.toRevisedGameRound(): GameRound {
    val encryptedPlays = this.split(" ")
    val theirPlay = encryptedPlays.first().toPlay()
    return GameRound(theirPlay, myPlay(theirPlay, encryptedPlays.last()))
}

fun revisedTotalScore(encryptedRounds: List<String>) =
    encryptedRounds.filter { it.isNotEmpty() }.sumOf { it.toRevisedGameRound().score }
