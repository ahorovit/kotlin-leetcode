import java.util.*

/*

https://leetcode.com/problems/last-stone-weight/

We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)


 */

fun main()
{
    println(lastStoneWeight(intArrayOf(2,7,4,1,8,1)))
}


fun lastStoneWeight(stones: IntArray): Int {

    val maxHeap = PriorityQueue<Int>() { o1, o2 -> o2 - o1 }

    stones.forEach { maxHeap.add(it) }

    while (maxHeap.size > 1 ){
        val y = maxHeap.poll()
        val x = maxHeap.poll()

        if (y > x) {
            maxHeap.add(y-x)
        }
    }

    return maxHeap.peek() ?: 0
}

