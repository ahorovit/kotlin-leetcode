/*
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */


fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) return null
    if (head.next == null) return TreeNode(head.`val`)

    var slow: ListNode = head
    var fast = head
    var prev: ListNode = head

    while(fast?.next != null) {
        prev = slow
        slow = slow.next!!
        fast = fast.next?.next
    }

    prev.next = null

    val root = TreeNode(slow.`val`)
    root.left = sortedListToBST(head)
    root.right = sortedListToBST(slow.next)

    return root
}