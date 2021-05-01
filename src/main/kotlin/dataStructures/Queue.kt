package dataStructures

import java.util.*

class Queue<T>(val size: Int = 1000) {
    private var count = 0
    private var front = 0
    private var back = 0

    @Suppress("UNCHECKED_CAST")
    private val queue = Array<Any?>(size) { null } as Array<T?>

    fun enqueue(new: T) {
        if (count >= size) throw Exception("Queue is full")
        queue[back] = new
        back = if(back == size-1) 0 else back+1
        count++
    }

    fun dequeue(): T? {
        if (isEmpty()) return null

        val res = queue[front]
        front = if (front == size-1) 0 else front+1
        count--

        return res
    }

    fun peek(): T? {
        return if (isEmpty()) null else queue[front]
    }

    private fun isEmpty() = count == 0
}


fun main() {
    val queue = Queue<Int>(size = 2)

    queue.enqueue(4)
    queue.enqueue(5)

    println(queue.peek())    // 4
    println(queue.dequeue()) // 4
    println(queue.peek())    // 5

    queue.enqueue(6)
    queue.enqueue(7)    // Exception: Queue is full
}

fun _main() {
    val queue = LinkedList<Int>()

}