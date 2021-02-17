/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Notice that the solution set must not contain duplicate triplets.
 */

fun main() {
    val testCases = listOf(
        Pair(intArrayOf(-1,0,1,2,-1,-4), listOf(listOf(-1,-1,2),listOf(-1,0,1))),

    )

    for (testCase in testCases) {
        val input = testCase.first
        val res = threeSum(input)
        println("""Input "${input.toList()}" --> Output "$res"""")

        if (res != testCase.second) {
            println("""ERROR: "$res" != "${testCase.second}"""")
            break
        }
    }
}


fun threeSum(nums: IntArray): List<List<Int>> {
    val result: MutableSet<List<Int>> = mutableSetOf()

    for (i in nums.indices) {
        for (j in i+1 until nums.count()) {
            for (k in j+1 until nums.count()) {
                if (nums[i] + nums[j] + nums[k] == 0)
                {
                    result.add(listOf(nums[i], nums[j], nums[k]))
                }
            }
        }
    }


    return result.toList()
}