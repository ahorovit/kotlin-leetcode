
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?

 */

fun main()
{

}






fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    if (head.next == null) return null

    val dummy = addDummyHead(head)
    val fast = getFastNode(dummy, n+1)
    val slow = getSlowNode(dummy, fast)
    slow.next = slow.next?.next

    return dummy.next
}

fun addDummyHead(head: ListNode): ListNode {
    val dummy = ListNode(-1)
    dummy.next = head
    return dummy
}

fun getFastNode(head: ListNode, n: Int): ListNode?
{
    var fast: ListNode? = head
    repeat(n) {
        fast = fast?.next
    }

    return fast
}

fun getSlowNode(head: ListNode, fastStart: ListNode?): ListNode
{
    var slow = head
    var fast = fastStart

    while (fast != null) {
        fast = fast.next
        slow = slow.next ?: throw Exception("invalid input list")
    }

    return slow
}
