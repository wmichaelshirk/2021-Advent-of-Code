fun main() {
    fun part1(input: List<String>): Int {

        return input.map { it.toInt() }
            .zipWithNext()
            .count { it.second > it.first }
    }

    fun part2(input: List<String>): Int {

        return input.map { it.toInt() }
            .windowed(size = 3)
            .map { it.sum() }
            .zipWithNext()
            .count { it.second > it.first }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
