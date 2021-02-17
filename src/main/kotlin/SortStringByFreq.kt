import java.lang.StringBuilder

fun main()
{
    println(frequencySort("tree"))
}

fun frequencySort(s: String): String {
    val map = hashMapOf<Char, Int>()

    s.forEach { c -> map[c] = map.getOrDefault(c, 0) + 1 }

    val result = StringBuilder()
    map.toList().sortedByDescending { (_, value) -> value }.forEach {
        result.append(it.first.toString().repeat(it.second))
    }

    return result.toString()
}