/*
https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 */

fun main()
{
    val obj = SolutionParens()

    obj.generateParenthesis(4).forEach{ println(""""$it"""") }

    println("done")
}


class SolutionParens {
    val results = mutableListOf<String>()

    fun generateParenthesis(n: Int): List<String> {
        build(n, StringBuilder(), 0, 0)
        return results
    }

    private fun build(n: Int, builder: StringBuilder, open: Int, closed: Int) {
        if (open == n && closed == n) {
            results.add(builder.toString())
        }

        for(c in getCandidates(n, open, closed)) {
            builder.append(c)

            when(c) {
                '(' -> build(n, builder, open+1, closed)
                ')' -> build(n, builder, open, closed+1)
            }

            builder.deleteCharAt(builder.length-1)
        }
    }

    private fun getCandidates(n: Int, open: Int, closed: Int): List<Char> {
        return when {
            closed >= open -> listOf('(')
            open < n && closed < n -> listOf('(', ')')
            closed < n -> listOf(')')
            else -> listOf()
        }
    }
}