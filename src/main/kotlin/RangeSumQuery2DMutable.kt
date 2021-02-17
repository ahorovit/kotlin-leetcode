/*
https://leetcode.com/problems/range-sum-query-2d-immutable/
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 */


fun main() {

//    val obj = NumMatrix(arrayOf(
//      intArrayOf(3, 0, 1, 4, 2),
//      intArrayOf(5, 6, 3, 2, 1),
//      intArrayOf(1, 2, 0, 1, 5),
//      intArrayOf(4, 1, 0, 1, 7),
//      intArrayOf(1, 0, 3, 0, 5),
//    ))
//
//    println(obj.sumRegion(2, 1, 4, 3))
//    println(obj.sumRegion(1, 1, 2, 2))
//    println(obj.sumRegion(1, 2, 2, 4))

    val obj = NumMatrix(arrayOf())
}


class NumMatrixMutable(matrix: Array<IntArray>) {
    val currentMatrix = matrix
    val cache = cacheInput(matrix)

    private fun cacheInput(matrix: Array<IntArray>): Array<IntArray> {
        if (matrix.isEmpty()) return arrayOf()

        val cache = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) { 0 } }

        for (row in matrix.indices) {
            for (col in matrix[0].indices) {
                cache[row + 1][col + 1] = cache[row][col + 1] + cache[row + 1][col] + matrix[row][col] - cache[row][col]
            }
        }

        return cache
    }

    fun update(row: Int, col: Int, `val`: Int) {
        val currentVal = currentMatrix[row][col]

        for (i in row + 1 until cache.size) {
            for (j in col + 1 until cache[0].size) {
                cache[i][j] += (`val` - currentVal)
            }
        }

        currentMatrix[row][col] = `val`
    }


    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return cache[row2 + 1][col2 + 1] - cache[row1][col2 + 1] - cache[row2 + 1][col1] + cache[row1][col1]
    }
}
