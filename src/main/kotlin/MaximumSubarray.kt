/*

https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 */
import kotlin.math.max


// Kadane's Algorithm
//fun maxSubArray(nums: IntArray): Int {
//    val maxAtI = IntArray(nums.size)
//    var maxValue = Int.MIN_VALUE
//
//
//    for ((i,value) in nums.withIndex()) {
//        maxAtI[i] = if(i == 0) {
//             max(0, value)
//        } else {
//            max(0, maxAtI[i-1] + value)
//        }
//
//        maxValue = max(maxValue, value)
//    }
//
//    val maxOfSums = maxAtI.maxOrNull()!!
//
//    return if (maxOfSums == 0) maxValue else maxOfSums
//}

// Greedy
fun maxSubArray(nums: IntArray): Int {
    var currSum = nums[0]
    var maxSum = nums[0]

    for (i in 1 until nums.size) {
        currSum = max(nums[i], currSum + nums[i])
        maxSum = max(maxSum, currSum)
    }

    return maxSum
}
