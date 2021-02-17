/*
https://leetcode.com/problems/find-the-town-judge/

In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:
-The town judge trusts nobody.
-Everybody (except for the town judge) trusts the town judge.
-There is exactly one person that satisfies properties 1 and 2.

You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */

// If there's a judge, we expect to see:
// N-1 edges directed at one vertex
// 0 edges from that vertex
// --> no other vertex has this

/*
Complexity Analysis:

We iterate over the Edges (E)
We then interate over the People (N)
Therefore the time complexity is O(N + E)

*Optimization: If there are not at least N-1 edges, we know there is no judge, so can exit early O(1) in the best case
--> In all other cases, E >= N, so the time complexity is O(E)

Space Complexity: we created an array of Person of size N
therefore Space complexity is O(N)

 */


fun main() {
    findJudge(3, arrayOf(intArrayOf(1,3), intArrayOf(2,3), intArrayOf(3,1)))
}

fun findJudge(N: Int, trust: Array<IntArray>): Int {
    // *optimization: at a minimum, there must be N-1 edges for a judge to exist
    if (trust.size < N-1) {
        return -1
    }

    val town = Array(N) { index -> Person(index+1) }

    for (edge in trust) {
        town[edge[0] - 1].trusts += 1
        town[edge[1] - 1].trustedBy += 1
    }

    val judges = town.filter { it.trusts == 0 && it.trustedBy == N-1 }

    return if (judges.count() == 1) {
        judges.first().index
    } else {
        -1
    }
}

data class Person(
    val index: Int,
    var trusts: Int = 0,
    var trustedBy: Int = 0
)