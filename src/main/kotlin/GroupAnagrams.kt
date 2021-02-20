/*
https://leetcode.com/problems/group-anagrams/

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

fun main()
{
    groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
}



val map = HashMap<String, MutableList<String>>()

fun groupAnagrams(strs: Array<String>): List<List<String>> {

    for (str in strs) {
        val alpha = alphabetize(str)

        if (map.containsKey(alpha)) {
            map[alpha]!!.add(str)
        } else {
            map[alpha] = mutableListOf(str)
        }
    }

    return map.toList().map { it.second }
}

fun alphabetize(str: String): String {
    if (str.isEmpty()) {
        return str
    }

    val charArray = str.toCharArray()
    charArray.sort()

    return String(charArray)
}
