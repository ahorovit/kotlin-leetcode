/*

https://leetcode.com/problems/kth-largest-element-in-a-stream/
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Returns the element representing the kth largest element in the stream.
 */
import java.util.*

fun main() {

    val obj = KthLargest(10, intArrayOf(1,2,3))


}


class KthLargest(val k: Int, nums: IntArray) {
    // The head of this queue is the least element with respect to the specified ordering.
    private val minHeap: PriorityQueue<Int> = PriorityQueue(k) { x, y -> x - y }

    init {
        nums.forEach{ add(it) }
    }

    // IF we only store the largest elements in a minHeap, the head value will always be the Kth largest
    fun add(`val`: Int): Int {

        if (minHeap.size < k) {
            minHeap.add(`val`)
        } else if (minHeap.peek() < `val`) {
            // val is the new Kth largest
            minHeap.poll()
            minHeap.add(`val`)
        }

        return minHeap.peek()
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */