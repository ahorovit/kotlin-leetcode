
/*

https://leetcode.com/contest/weekly-contest-235/problems/minimum-absolute-sum-difference/

You are given two positive integer arrays nums1 and nums2, both of length n.

The absolute sum difference of arrays nums1 and nums2 is defined as the sum of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).

You can replace at most one element of nums1 with any other element in nums1 to minimize the absolute sum difference.

Return the minimum absolute sum difference after replacing at most one element in the array nums1. Since the answer may be large, return it modulo 109 + 7.

|x| is defined as:

x if x >= 0, or
-x if x < 0.
 */


import kotlin.math.abs

fun main()
{
    println(minAbsoluteSumDiff(
        intArrayOf(1,10,4,4,2,7),
        intArrayOf(9,3,5,1,7,4)
    ))
}


fun minAbsoluteSumDiff(nums1: IntArray, nums2: IntArray): Int {

    var totalDiff = 0
    var maxDiff = Pair(0,0)

    for (i in nums1.indices) {
        val diff = abs(nums1[i] - nums2[i])
        if (diff > maxDiff.first) {
            maxDiff = Pair(diff, i)
        }

        totalDiff += diff
    }

    if (totalDiff == 0) {
        return 0
    }

    val target = nums2[maxDiff.second]
    var minDiff = maxDiff.first

    for (j in nums1) {
        val diff = abs(j - target)

        if (diff < minDiff)
        {
            minDiff = diff
        }
    }

    totalDiff -= (maxDiff.first - minDiff)

    return totalDiff % (1_000_000_000 + 7)
}