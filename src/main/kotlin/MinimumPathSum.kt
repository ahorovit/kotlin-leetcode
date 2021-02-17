/*
https://leetcode.com/problems/minimum-path-sum/
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */

import kotlin.math.min
fun minPathSum(grid: Array<IntArray>): Int {

    val m = grid.size - 1
    val n = grid[0].size - 1

    for (i in 0..m) {
        for (j in 0..n) {
            grid[i][j] = when {
                i == 0 && j == 0 -> grid[i][j]
                i == 0 -> grid[i][j] + grid[i][j-1]
                j == 0 -> grid[i][j] + grid[i-1][j]
                else -> min(
                    grid[i][j] + grid[i][j-1],
                    grid[i][j] + grid[i-1][j]
                )
            }
        }
    }

    return grid[m][n]
}