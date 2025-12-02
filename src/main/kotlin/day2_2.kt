import java.io.File
import kotlin.text.toLong

fun main() {
    File("src/main/kotlin/resources/day2.txt").useLines { lines ->
        lines.forEach { line ->
            val result = line.split(",").fold(0L) { sum, range ->
                val (first, last) = range.split("-")
                sum + countMatchesInRange(first.toLong(), last.toLong())
            }
            print(result)
        }
    }
}

private fun countMatchesInRange(first: Long, last: Long): Long {
    return (first..last).fold(0L) { partialSum, n ->
        n.toString().let { repr ->
            partialSum + if (isRepeatingPattern(repr)) n else 0
        }
    }
}

private fun isRepeatingPattern(str: String): Boolean {
    return (1..str.length / 2).any { patternSize ->
        str.substring(0, patternSize).repeat(str.length / patternSize) == str
    }
}
