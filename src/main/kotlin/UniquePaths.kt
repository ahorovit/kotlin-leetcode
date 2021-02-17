/*
https://leetcode.com/problems/unique-paths/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 */

// Recursion + memoization
//val mem = hashMapOf<Pair<Int, Int>, Int>()
//var M = -1
//var N = -1
//
//
//fun uniquePaths(m: Int, n: Int): Int {
//    M = m-1
//    N = n-1
//
//    return getPaths(0,0)
//}
//
//fun getPaths(i: Int, j: Int): Int {
//    val coord = Pair(i, j)
//
//    return if (i == M || j == N)
//        1
//    else if (mem.containsKey(coord)) {
//        mem[coord]!!
//    } else {
//        val res = getPaths(i+1, j) + getPaths(i, j+1)
//        mem[coord] = res
//        res
//    }
//}

// Dynamic programming
fun uniquePaths(m: Int, n: Int): Int {
    val paths = Array(m) { IntArray(n) { 0 } }

    for( i in 0 until m ) {
        for (j in 0 until n) {
            paths[i][j] = if (i == 0 || j == 0) {
                1
            } else {
                paths[i-1][j] + paths[i][j-1]
            }
        }
    }

    return paths[m-1][n-1]
}

/*
https://leetcode.com/problems/unique-paths-ii/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

 */



fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    if (obstacleGrid.isEmpty()) {
        return 0
    }

    val m = obstacleGrid.size
    val n = obstacleGrid[0].size

    val paths = Array(m) { IntArray(n) { 0 } }

    for( i in 0 until m ) {
        for (j in 0 until n) {
            paths[i][j] = when {
                obstacleGrid[i][j] == 1 -> 0
                i == 0 && j == 0 -> 1
                j == 0 -> paths[i-1][j]
                i == 0 -> paths[i][j-1]
                else -> paths[i-1][j] + paths[i][j-1]
            }
        }
    }

    return paths[m-1][n-1]
}