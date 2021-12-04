import java.lang.Exception

fun main() {
    fun part1(input: List<String>): Int {

        val matrix = input.map { it.toList() }

        val mask = "1".repeat(input.first().length).toInt(2)

        //rotate
        val newMatrix = matrix.first()
            .mapIndexed { index, c ->
                matrix.map { it -> it[index] }
            }

        val gammaRate = newMatrix.map { col -> col
            .groupBy { it }
                .mapValues { it.value.size }
                .maxByOrNull { it.value }
                ?.key
        }.joinToString("")
            .toInt(2)

        var epsilonRate = mask xor gammaRate
        return epsilonRate * gammaRate
    }

    fun part2(input: List<String>): Int {

        var matrix = input.map { it.toList() }

        var index = 0
        while (matrix.size > 1) {
           var maxDigit = matrix.map { it[index] }
                .groupBy { it }
                .mapValues { it.value.size }
               .maxOfWith(compareBy({ it.value }, { it.key == '1' })) { it }
               ?.key
            matrix = matrix.filter { it[index] == maxDigit  }
            index += 1
        }

        val oxygenGeneratorRating = matrix.first()
            .joinToString("")
            .toInt(2)

        matrix = input.map { it.toList() }
        index = 0
        while (matrix.size > 1) {
            var minDigit = matrix.map { it[index] }
                .groupBy { it }
                .mapValues { it.value.size }
                .minOfWith(compareBy({ it.value }, { it.key != '0' })) { it }
                ?.key

            matrix = matrix.filter { it[index] == minDigit  }
            index += 1
        }

        val co2ScrubberRating  = matrix.first()
            .joinToString("")
            .toInt(2)

        val lifeSupportRating = oxygenGeneratorRating * co2ScrubberRating

        return lifeSupportRating
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
