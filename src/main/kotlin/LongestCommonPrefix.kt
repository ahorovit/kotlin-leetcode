import kotlin.math.*

fun main() {
    val testCases = listOf(
        Pair(arrayOf("cir", "car"), "c"),
        Pair(arrayOf("flower", "flow", "flight"), "fl"),
        Pair(arrayOf("dog", "racecar", "car"), ""),
        Pair(arrayOf("abcde", "abcdef", "abc"), "abc"),
        Pair(arrayOf(), ""),
    )

    for (testCase in testCases) {
        val input = testCase.first
        val res = longestCommonPrefix(input)
        println("""Input "${input.toList()}" --> Output "$res"""")

        if (res != testCase.second) {
            println("""ERROR: "$res" != "${testCase.second}"""")
            break
        }
    }
}


/*
    commonPrefix = string[0]
    foreach string
        foreach character in string
            if character matches with commonPrefix character, continue
            if char doesn't match, truncate commonPrefix

    return remaining commonPrefix
 */


fun longestCommonPrefix(strs: Array<String>): String {
    var commonPrefix = strs.getOrNull(0) ?: ""

    for (string in strs) {
        val prefix = StringBuilder()
        val checkLength = min(commonPrefix.length, string.length)

        loop@for(i in 0 until checkLength) {
            if(string[i] == commonPrefix[i]) {
                prefix.append(string[i])
            } else {
                break@loop
            }
        }

        if (prefix.isEmpty()) {
            return ""
        }

        commonPrefix = prefix.toString()
    }

    return commonPrefix
}