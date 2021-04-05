/*
https://leetcode.com/problems/3sum/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */

fun main()
{
    threeSumII(intArrayOf(0,1,-1))
}


fun threeSumII(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    var lastVal: Int? = null

    outer@for((i, iVal) in nums.withIndex())
    {
        if (iVal == lastVal) continue@outer
        if (iVal > 0) break@outer


        var j = i+1
        var k = nums.size-1

        while (j < k) {
            val sum = nums[j] + nums[k] + iVal

            when {
                sum < 0 -> j++
                sum > 0 -> k--
                else -> {
                    result.add(listOf(iVal, nums[j++], nums[k--]))

                    while (j < k && nums[j] == nums[j-1]) {
                        j++
                    }
                }
            }

        }

        lastVal = iVal
    }

    return result
}
