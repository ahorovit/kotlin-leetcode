/*
https://leetcode.com/problems/climbing-stairs/

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */


/*
 At each step, i, you can either take one step or two with your next move
 */

// Brute force:
//fun climbStairs(n: Int): Int {
//    return helpClimb(0, n)
//}
//
//fun helpClimb(i: Int, n: Int): Int {
//    return when {
//        i > n -> 0
//        i == n -> 1
//        else -> helpClimb(i+1, n) + helpClimb(i+2, n)
//    }
//}

// Memoization:

//val mem = mutableMapOf<Int, Int>()
//
//fun climbStairs(n: Int): Int {
//    return helpClimb(0, n)
//}
//
//fun helpClimb(i: Int, n: Int): Int {
//    if (mem.containsKey(i)) return mem[i]!!
//
//    val res = when {
//        i > n -> 0
//        i == n -> 1
//        else -> helpClimb(i+1, n) + helpClimb(i+2, n)
//    }
//
//    mem[i] = res
//    return res
//}

// Dynamic Programming:

fun climbStairs(n: Int): Int {
    if (n < 3) {
        return n
    }

    val dp = IntArray(n+1)
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = dp[i-1] + dp[i-2]
    }

    return dp[n]
}


