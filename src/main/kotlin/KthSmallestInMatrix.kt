import java.util.*

/*

https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 */

// use a maxHeap with capacity = K
// iterate through values in matrix, filling heap
// once filled, check remaining elements against head
// if el < head, replace head
// after heap is filled, once next row with a first element larger than head, we're done
// skip remainder of a row if el > head

fun main() {
    val input = arrayOf(
        intArrayOf(1,5,9),
        intArrayOf(10,11,13),
        intArrayOf(12,13,15),
    )

    println(kthSmallest(input, 8))
}


fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {

    val maxHeap = PriorityQueue<Int>(k) { o1, o2 -> o2 - o1 }

    outer@for (row in matrix) {
        inner@for ((index, element) in row.withIndex()) {
            if (maxHeap.size < k) {
                maxHeap.add(element)
                continue@inner
            }

            if (element <= maxHeap.peek()) {
                maxHeap.poll()
                maxHeap.add(element)
            } else if (index > 0) {
                continue@outer
            } else {
                break@outer
            }
        }
    }

    return maxHeap.peek()
}

