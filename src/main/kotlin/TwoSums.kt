/*
https://leetcode.com/problems/two-sum/
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */


import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

//@RunWith(Parameterized::class)
//class TwoSumTest(val nums: IntArray, val target: Int, val expected: IntArray) {
//
//    companion object {
//        @JvmStatic
//        @Parameterized.Parameters
//        fun data(): Collection<Array<Any>> {
//            return listOf(
//                arrayOf(intArrayOf(2,7,11,15), 9, intArrayOf(0,1)),
//                arrayOf(intArrayOf(3,2,4), 6, intArrayOf(1,2)),
//                arrayOf(intArrayOf(3,3), 6, intArrayOf(0,1)),
////                arrayOf(intArrayOf(), 1, intArrayOf()),
//            )
//        }
//    }
//
//    @Test
//    fun testTwoSum() {
//        assertThat(twoSum(nums, target), equalTo(expected))
//    }
//}


fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for ((index, value) in nums.withIndex()) {
        map[target - value]?.let {
            return intArrayOf(it, index)
        }

        map[value] = index
    }

    return intArrayOf(-1, -1)
}

