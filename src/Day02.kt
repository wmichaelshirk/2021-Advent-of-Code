import java.lang.Exception

fun main() {
    fun part1(input: List<String>): Int {
        var pos = 0
        var depth = 0

        input.forEach {
            var command = it.split(" ")
            var opcode = command.first()
            var argument = command[1].toInt()

            when (opcode) {
                "forward" -> pos += argument
                "down" -> depth += argument
                "up" -> depth -= argument
                else -> throw Exception("Invalid instruction")
            }
        }

        return pos * depth
    }

    fun part2(input: List<String>): Int {

        var pos = 0
        var depth = 0
        var aim = 0

        input.forEach {
            var command = it.split(" ")
            var opcode = command.first()
            var argument = command[1].toInt()

            when (opcode) {
                "forward" -> {
                    pos += argument
                    depth += aim * argument
                }
                "down" -> aim += argument
                "up" -> aim -= argument
                else -> throw Exception("Invalid instruction")
            }
        }

        return pos * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
