/*
https://leetcode.com/problems/reorder-list/
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 */


fun main() {
    val testCases = listOf(
//        Pair(intArrayOf(1), intArrayOf(1)),
//        Pair(intArrayOf(), intArrayOf()),
        Pair(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 5, 2, 4, 3)),
        Pair(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(1, 6, 2, 5, 3, 4)),
        Pair(intArrayOf(1, 2, 3), intArrayOf(1, 3, 2)),
    )

    for (testCase in testCases) {
        val input = buildLinkedList(testCase.first)
        reorderList(input)
        val result = input?.listToIntArray()

        if (!result.contentEquals(testCase.second)) {
            println("""ERROR: input: ${testCase.first.toList()} expected: ${testCase.second.toList()} got: ${result?.toList()}""")
            break
        } else {
            println("""SUCCESS: input: ${testCase.first.toList()} expected: ${testCase.second.toList()} got: ${result?.toList()}""")
        }
    }
}

fun reorderList(head: ListNode?): Unit {
    if (head?.next == null) {
        return
    }

    val middle = middleNode(head)
    val reversed = reverseList(middle)
    interleaveLists(head, reversed, middle)
}

fun interleaveLists(l1: ListNode?, l2: ListNode?, link: ListNode?) {
    var node1 = l1
    var node2 = l2
    var tail = node1

    while (node1 != null && node2 != null) {
        if (node1.next === link) {
            node1.next = null
        }

        val next1 = node1.next
        val next2 = node2.next

        node1.next = node2
        tail = node2 ?: tail

        node2.next = next1
        tail = next1 ?: tail

        node1 = next1
        node2 = next2
    }

    tail?.next = node2
}

