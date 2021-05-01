class EscapeLargeMaze {

    var targetX = -1
    var targetY = -1
    var memo = Array(N) { IntArray(N) { 0 } }

    fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
        if (blocked.isEmpty()) return true
        targetX = target[0]
        targetY = target[1]

        for (wall in blocked) {
            memo[wall[0]][wall[1]] = DEAD_END
        }

        return search(source[0], source[1])
    }

    fun search(i: Int, j: Int): Boolean {
        if (i == targetX && j == targetY) return true
        memo[i][j] = VISITING
        for ((nextI, nextJ) in neighbors(i, j)) {
            if (search(nextI, nextJ)) return true
        }
        memo[i][j] = DEAD_END
        return false
    }

    private fun neighbors(i: Int, j: Int): List<Pair<Int, Int>> {
        return listOf(
            Pair(i, j + 1), Pair(i, j - 1),
            Pair(i + 1, j), Pair(i - 1, j)
        ).filter {
            it.first in 0 until N &&
            it.second in 0 until N &&
            memo[it.first][it.second] == 0
        }
    }

    companion object {
        const val N = 1_000_000
        const val VISITING = 1
        const val DEAD_END = 2
    }
}