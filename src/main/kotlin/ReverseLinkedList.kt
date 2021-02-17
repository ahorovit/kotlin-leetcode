/*
https://leetcode.com/problems/reverse-linked-list/
Reverse a singly linked list.
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

fun main() {
    val testCases = listOf(
        intArrayOf(1),
        intArrayOf(),
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(1, 2, 3, 4, 5, 6),
        intArrayOf(1, 2, 3)
    )

    for (testCase in testCases) {
        val input = buildLinkedList(testCase)
        val result = reverseList(input)?.listToIntArray() ?: intArrayOf()

        if (!result.contentEquals(testCase.reversed().toIntArray()))
        {
            println("""ERROR: input: ${testCase.toList()} expected: ${testCase.reversed().toList()} got: ${result.toList()}""")
        }

    }
}

fun ListNode.listToIntArray() : IntArray
{
    var node: ListNode? = this
    val result: MutableList<Int> = mutableListOf()

    while(node != null) {
        result.add(node.`val`)
        node = node.next
    }

    return result.toIntArray()
}


fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var current: ListNode? = head
    var next: ListNode? = head?.next

    while (current != null) {
        current.next = prev
        prev = current
        current = next
        next = current?.next
    }

    return prev
}