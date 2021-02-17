/*
https://leetcode.com/problems/implement-strstr/
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */

fun main() {
    val testCases = listOf(
        arrayOf("hello", "ll", 2),
        arrayOf("aaaaa", "bba", -1),
        arrayOf("", "", 0),
        arrayOf("", "a", -1),
        arrayOf("hello", "", 0),
    )

    for (testCase in testCases) {

        val result = strStr(testCase[0] as String, testCase[1] as String)

        println("""Haystack:"${testCase[0]}" Needle: "${testCase[1]}", Result: "${result}"""")

        if (result != testCase[2]) {
            println("ERROR: expected result ${testCase[2]}")
            break
        }
    }
}

fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty()) {
        return 0
    }

    val limit = haystack.length - needle.length

    loop@ for (i in 0..limit) {
        if (haystack[i] != needle[0]) {
            continue@loop
        }

        for (j in 1 until needle.length) {
            if (haystack[i + j] != needle[j]) {
                continue@loop
            }
        }

        return i
    }

    return -1
}