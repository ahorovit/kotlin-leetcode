/*
https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, return the longest palindromic substring in s.


 */


fun main() {
//    println(longestPalindrome("babad"))
    println(longestPalindrome("ccc"))
}


var maxPalindrome = ""


fun longestPalindrome(s: String): String {
    if (s.length == 1) return s

    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) {
            checkPalBounds(s, i - 1, i)
        }

        if (i < s.length-1 && s[i - 1] == s[i + 1]) {
            checkPalBounds(s, i - 1, i + 1)
        }
    }

    return if (maxPalindrome.isNotEmpty()) maxPalindrome else s[0].toString()
}

fun checkPalBounds(input: String, left: Int, right: Int) {

    var i = left
    var j = right

    loop@ while (i >= 0 && j < input.length) {
        if (input[i] != input[j]) break@loop

        i --
        j ++
    }

    if (input.substring(i+1, j).length > maxPalindrome.length) {
        maxPalindrome = input.substring(i+1, j)
    }
}
