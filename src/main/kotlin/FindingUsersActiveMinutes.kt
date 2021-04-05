/*

https://leetcode.com/contest/weekly-contest-235/problems/finding-the-users-active-minutes/

You are given the logs for users' actions on LeetCode, and an integer k. The logs are represented by a 2D integer array logs where each logs[i] = [IDi, timei] indicates that the user with IDi performed an action at the minute timei.

Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.

The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed an action on LeetCode. A minute can only be counted once, even if multiple actions occur during it.

You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.

Return the array answer as described above.

 */

fun main()
{
    println(findingUsersActiveMinutes(
        arrayOf(
            intArrayOf(0,5),
            intArrayOf(1,2),
            intArrayOf(0,2),
            intArrayOf(0,5),
            intArrayOf(1,3),
        ),
        5
    ).toList())
}


fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
    val mapped = mapLogs(logs)

    val countsByMin = mapped.toList().groupingBy {it.second.size}.eachCount()

    return IntArray(k) {
        countsByMin[it+1] ?: 0
    }
}

fun mapLogs(logs: Array<IntArray>): HashMap<Int, HashSet<Int>> {
    val map = HashMap<Int, HashSet<Int>>()

    for (log in logs) {
        val id = log[0]
        val min = log[1]

        if (!map.containsKey(id)) {
            map[id] = HashSet<Int>()
        }

        map[id]?.add(min)
    }

    return map
}


//fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
//    val sorted = logs.sortedBy{ it[0] }
//
//    val result = intArrayOf()
//    var id: Int? = null
//    var
//    for(log in sorted) {
//        if (id == null) {
//            id = log[0]
//        }
//
//
//
//        if (log[0] != id) {
//
//        }
//
//
//    }
//
//
//    return intArrayOf()
//
//}