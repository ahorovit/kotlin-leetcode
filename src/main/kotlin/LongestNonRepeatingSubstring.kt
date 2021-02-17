
fun main() {
//    val input = "pwwkew"
//    val input = " "
    val input = "dvdf"
    val solution = Solution()
    val result = solution.lengthOfLongestSubstring(input)

    println("input: $input, longest nonrepeating substring: $result")
}



class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLen = 0
        var thisLen = 0
        val map = mutableMapOf<Char, Int>()
        var ii = 0

        while (ii < s.length) {
            val char = s[ii]

            if(!map.contains(char)) {
                thisLen++
                map[char] = ii
                maxLen = Math.max(thisLen, maxLen)
                ii++
            } else {
                ii = map[char]!! + 1
                thisLen = 0
                map.clear()
            }
        }

        return maxLen
    }
}