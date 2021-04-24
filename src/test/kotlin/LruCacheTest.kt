import DataStructures.LruCache
import org.junit.Test
import kotlin.test.assertEquals


class LruCacheTest {
    @Test
    fun testCacheHit() {
        val cache = LruCache<Int, String>({key: String -> key.length }, 2)

        assertEquals(1, cache.get("a"))
        assertEquals(1, cache.count)

        assertEquals(2, cache.get("ab"))
        assertEquals(2, cache.count)

        assertEquals(3, cache.get("abc"))
        assertEquals(2, cache.count)

    }
}