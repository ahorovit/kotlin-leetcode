import kotlin.math.max
import kotlin.math.min

/*
- Given n positive integers (a1, a2, a3...an), each representing point a point at (i, ai)
- n vertical lines are drawn with endpoints of line i are (i, ai) and (i, 0)

--> Find two lines that serve as walls of a container (x axis as floor) that can hold the most water
--> return the volume = area of rectangle of water
 */

fun main() {
    val testCases = listOf(
        Pair(intArrayOf(1, 1), 1),
        Pair(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7), 49),
        Pair(intArrayOf(4, 3, 2, 1, 4), 16),
        Pair(intArrayOf(1, 2, 1), 2)
    )

    for (testCase in testCases) {
        val input = testCase.first
        val res = maxArea(input)
        println("""Input "${input.toList()}" --> Output "$res"""")

        if (res != testCase.second) {
            println("ERROR: $res != ${testCase.second}")
            break
        }
    }
}

// brute force
//fun maxArea(height: IntArray): Int {
//    val indices = height.indices
//    val maxIndex = indices.count() - 1
//    var maxArea: Int = Int.MIN_VALUE
//
//    //optimization: skip pairs that have been checked O(n/2) is O(n)
//    for (i in indices) {
//        for (j in (i+1)..maxIndex) {
//            val base = j - i
//            val depth: Int = min(height[i], height[j])
//            val area = base * depth
//
//            maxArea = max(area, maxArea)
//        }
//    }
//
//    return maxArea
//}

// Optimized --> start with outside lines, and move one or the other inward
// --> Because height is limited by shorter line, we only need to move the shorter one in
// --> to move the taller line, the volume cannot increase, because the shorter one limits depth
fun maxArea(height: IntArray): Int {
    var maxArea: Int = Int.MIN_VALUE
    var i = 0
    var j = height.count() - 1

    while (i < j) {
        val base = j - i
        val depth: Int = min(height[i], height[j])
        val area = base * depth
        maxArea = max(area, maxArea)

        if (height[i] < height[j]) {
            i++
        } else {
            j--
        }
    }

    return maxArea
}