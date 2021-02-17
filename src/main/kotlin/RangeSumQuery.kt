/*
https://leetcode.com/problems/range-sum-query-immutable/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))

 */


// Brute force
//class NumArray(nums: IntArray) {
//    val numArray = nums
//
//    fun sumRange(i: Int, j: Int): Int {
//        var sum = 0
//        for (idx in i..j) {
//            sum += numArray[idx]
//        }
//        return sum
//    }
//
//}


class NumArray(nums: IntArray) {
    val sumCache = cacheInput(nums)

    private fun cacheInput(nums: IntArray): Array<Int> {
        val cache = Array(nums.size+1){ 0 }

        for((i, value) in nums.withIndex()) {
            cache[i+1] = cache[i] + value
        }

        return cache
    }

    fun sumRange(i: Int, j: Int): Int {
        return sumCache[j+1] - sumCache[i]
    }

}