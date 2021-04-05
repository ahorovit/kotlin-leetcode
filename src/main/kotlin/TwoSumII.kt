/*

https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
You may assume that each input would have exactly one solution and you may not use the same element twice.

 */

fun twoSumII(numbers: IntArray, target: Int): IntArray {
    var l = 0
    var r = numbers.size - 1

    while (l < r) {
        val sum = numbers[l] + numbers[r]

        when {
            sum > target -> r--
            sum < target -> l++
            else -> return intArrayOf(l+1, r+1)
        }
    }

    throw Exception("invalid input")
}