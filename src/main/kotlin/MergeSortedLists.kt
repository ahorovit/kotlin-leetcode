/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */


fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var node1 = l1
    var node2 = l2

    val preHead = ListNode(-1)
    var prev = preHead

    while (node1 != null && node2 != null) {

        if (node1.`val` < node2.`val`) {
            prev.next = node1
            node1 = node1.next
        } else {
            prev.next = node2
            node2 = node2.next
        }

        prev = prev.next!!
    }

    // One of the two lists must be null by now
    prev.next = node1 ?: node2

    return preHead.next
}

