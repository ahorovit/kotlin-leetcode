package dataStructures

/**
 *
 */
class LruCache<T,K> (private val run: (K) -> T, private val capacity: Int = 1000) {
    init {
        if (capacity < 2) {
            throw Exception("LruCache capacity minimum is 2")
        }
    }

    private val map = HashMap<K, LruNode<K,T>>()
    var count = 0
        private set

    private var lruKey: K? = null // head of LinkedList
    private var mruKey: K? = null // tail of LinkedList

    fun get(key: K): T {
        return if (map.containsKey(key)) {
            setMru(key)
            map[key]!!.value
        } else {
            val value = run(key)
            push(key, value)
            value
        }
    }

    private fun push(key: K, value: T) {
        if (count == capacity) {
            evictLru()
        }

        map[key] = LruNode(key, value)
        setMru(key)
        count++
    }

    private fun setMru(key: K) {
        val newMruNode = map[key] ?: return

        if (mruKey == null) {
            // first node in cache is both mru and lru
            lruKey = key
            mruKey = key
        } else {
            newMruNode.splice()
            map[mruKey]?.next = newMruNode
            mruKey = key
        }
    }

    private fun evictLru() {
        val evictKey = lruKey ?: return
        lruKey = map[evictKey]?.next?.key
        map.remove(evictKey)
        count--
    }
}

/**
 * Linked List Node implementation for LruCache
 */
class LruNode<K,T> (val key: K, val value: T) {
    var prev: LruNode<K,T>? = null
        set(value) {
            if (field === value) return
            field = value
            value?.next = this
        }

    var next: LruNode<K,T>? = null
        set(value) {
            if (field === value) return
            field = value
            value?.prev = this
        }

    /**
     * Remove node from its position, and link prev to next
     */
    fun splice() {
        prev?.next = next
        next?.prev = prev

        prev = null
        next = null
    }
}
