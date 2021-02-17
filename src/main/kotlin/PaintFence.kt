/*
https://leetcode.com/problems/paint-fence/


There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.
 */


/*
    at each post, you have a choice of k colors (k choices)
    there are then k-1 options for the next post

    Ci = (k-1) + C(i+1)
 */

fun main() {
    println(numWays(3, 2))
}


fun numWays(n: Int, k: Int): Int {
    return when {
        n == 0 -> 0
        k == 0 -> 0
        n == 1 -> k
        else -> solve(n, k, 1, null, true)
    }
}

fun solve(n: Int, k: Int, i: Int, prev: Int?, doubleAvailable: Boolean): Int {
    if (i == n) {
        return k - 1
    }

    var count = 0
    loop@ for (c in 1..k) {
        if (doubleAvailable && c == prev) {
            count += solve(n, k, i + 1, c, false)
        } else if (c == prev) {
            continue@loop
        }

        count += solve(n, k, i + 1, c, doubleAvailable)
    }

    return count
}
