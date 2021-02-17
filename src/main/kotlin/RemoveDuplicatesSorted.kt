/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.

Internally you can think of this:

 */

fun main() {
    val nums = intArrayOf(1,1,2)
    removeDuplicates(nums)

    println(nums.toList())
}



fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty())
        return 0

    var i = 0
    var j = 1

    while (j < nums.count()) {
        if (nums[j] == nums[i]) {
            j++
        } else {
            nums[i+1] = nums[j]
            i++
            j++
        }
    }

    return i+1
}