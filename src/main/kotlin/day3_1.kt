import java.io.File

fun main() {
    val result = File("src/main/kotlin/resources/day3.txt").useLines { lines ->
        lines.fold(0L) { joltage, line ->
            var numbers = line.toList().map { it.toString().toInt() }
            var count = 2
            var lineResult = ""
            while (count > 0) {
                val nextMax = numbers.dropLast(count-1).max()
                lineResult = lineResult.plus(nextMax.toString())
                numbers = numbers.drop(numbers.indexOf(nextMax) + 1)
                count--
            }
            joltage + lineResult.toLong()
        }
    }
    print(result)
}
