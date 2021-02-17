

// https://leetcode.com/problems/middle-of-the-linked-list/

//Given a non-empty, singly linked list with head node head, return a middle node of linked list.
//
//If there are two middle nodes, return the second middle node.


//fun getMiddleNode(head: ListNode): ListNode {
//    var slow: ListNode? = head
//    var fast: ListNode? = head
//
//    while (fast?.next != null) {
//        slow = slow?.next
//        fast = fast.next?.next
//    }
//
//    return slow ?: head
//}

fun main() {
    val testCases = listOf(
        Pair(intArrayOf(1), 1),
        Pair(intArrayOf(), null),
        Pair(intArrayOf(1,2,3,4,5), 3),
        Pair(intArrayOf(1,2,3,4,5,6), 4),
        Pair(intArrayOf(1,2,3), 2),
    )

    for (testCase in testCases)
    {
        val input = buildLinkedList(testCase.first)
        val result = middleNode(input)
        if (result?.`val` != testCase.second) {
            println("""ERROR: input: ${testCase.first.toList()} expected: ${testCase.second} got ${result?.`val`}""")
        }
    }
}

fun buildLinkedList(values: IntArray) : ListNode?
{
    val preHead = ListNode(-1)
    var tail = preHead

    for(value in values) {
        tail.next = ListNode(value)
        tail = tail.next!!
    }

    return preHead.next
}

fun middleNode(head: ListNode?): ListNode? {
    var fastNode = head
    var slowNode = head

    while(fastNode?.next != null) {
        fastNode = fastNode.next?.next
        slowNode = slowNode?.next
    }

    return slowNode
}
