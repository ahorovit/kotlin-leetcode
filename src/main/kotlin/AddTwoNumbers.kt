fun main() {
//    val first = intArrayOf(2, 4, 3)
//    val second = intArrayOf(5, 6, 4)

    val first = intArrayOf(9,9,9,9,9,9,9)
    val second = intArrayOf(9,9,9,9)


    val solution = aSolution()

    val result = solution.addTwoNumbers(
        buildList(first),
        buildList(second)
    )

    result?.print()
}

fun ListNode.print() = run {
    var current: ListNode? = this
    val valueList = mutableListOf<Int>()

    do {
        current?.`val`?.let {
            valueList.add(it)
        }

        current = current?.next

    } while(current != null)

    println(valueList)
}

fun buildList(values: IntArray): ListNode
{
    var head: ListNode? = null
    var tail: ListNode? = null

    for(value in values)
    {
        val newNode = ListNode(value)

        if (tail != null) tail.next = newNode
        if (head == null) head = newNode

        tail = newNode
    }

    head?.let {
        return it
    }

    throw Exception("head not resolved")
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class aSolution {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode? {
        var prevTail: ListNode?
        var resTail: ListNode? = null
        var resHead: ListNode? = null
        var carry = 0

        var node1: ListNode? = l1
        var node2: ListNode? = l2

        while(node1 != null || node2 != null || carry == 1)
        {
            prevTail = resTail

            val newVal = (node1?.`val` ?: 0) + (node2?.`val` ?: 0) + carry

            resTail = ListNode(newVal % 10)
            prevTail?.next = resTail

            carry = if (newVal > 9) 1 else 0

            if (resHead == null) {
                resHead = resTail
            }

            node1 = node1?.next
            node2 = node2?.next
        }

        return resHead
    }

//    private fun goToLast(head: ListNode): MutableList<ListNode> {
//        var node: ListNode? = head
//        val res = mutableListOf<ListNode>()
//
//        do {
//            node?.let { res.add(it) }
//            node = node?.next
//        } while (node != null)
//
//        return res
//    }
//
//    private fun MutableList<ListNode>.pop() = removeLastOrNull()
}