import java.lang.Exception

fun main() {
    val testCases = listOf(
        Pair(3, "III"),
        Pair(4, "IV"),
        Pair(9, "IX"),
        Pair(58, "LVIII"),
        Pair(1994, "MCMXCIV"),
    )

    for (testCase in testCases) {
        val input = testCase.first
        val res = intToRoman(input)
        println("""Input "$input" --> Output "$res"""")

        if (res != testCase.second) {
            throw Exception("$res != ${testCase.second}")
        }
    }
}


// The crux of this problem is simply knowing the rules of Roman Numerals
// subtraction rules:
// --> only C/X/I can be used to subtract
// --> only the next smallest of these three can be used to subtract
val numeralMap = listOf(
    Pair(1000, "M"),
    Pair(900, "CM"),
    Pair(500, "D"),
    Pair(400, "CD"),
    Pair(100, "C"),
    Pair(90, "XC"),
    Pair(50, "L"),
    Pair(40, "XL"),
    Pair(10, "X"),
    Pair(9, "IX"),
    Pair(5, "V"),
    Pair(4, "IV"),
    Pair(1, "I"),
)

fun intToRoman(num: Int): String {
    val result = StringBuilder()
    var remainder: Int = num

    while (remainder > 0) {
        loop@ for (i in numeralMap.indices) {
            val pair = numeralMap[i]

            if (pair.first <= remainder) {
                result.append(pair.second)
                remainder -= pair.first
                break@loop
            }

            val nextPair = numeralMap.getOrNull(i+1) ?: break@loop

            if (nextPair.first <= remainder) {
                result.append(nextPair.second)
                remainder -= (nextPair.first)
                break@loop
            }
        }
    }

    return result.toString()
}
