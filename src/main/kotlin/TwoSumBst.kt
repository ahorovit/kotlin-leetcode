/*
https://leetcode.com/problems/two-sum-bsts/submissions/

Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.

 */


//    fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
//        return searchFirst(root1, root2, target)
//    }
//
//    fun searchFirst(node1: TreeNode?, root2: TreeNode?, target: Int): Boolean
//    {
//        if (node1 == null || root2 == null) return false
//
//        return searchSecond(root2, target - node1.`val`)
//                || searchFirst(node1.left, root2, target)
//                || searchFirst(node1.right, root2, target)
//    }
//
//    fun searchSecond(node2: TreeNode?, remainder: Int): Boolean {
//        if (node2 == null) return false
//
//        return when {
//            node2.`val` > remainder -> searchSecond(node2.left, remainder)
//            node2.`val` < remainder -> searchSecond(node2.right, remainder)
//            else -> true
//        }
//    }


    val complementMap = HashSet<Int>()

    fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
        mapComplements(root1, target)
        return searchSecond(root2)
    }

fun searchSecond(node2: TreeNode?): Boolean {
    if (node2 == null) return false

    return complementMap.contains(node2.`val`)
            || searchSecond(node2.left)
            ||searchSecond(node2.right)
}

fun mapComplements(node1: TreeNode?, target: Int) {
    if (node1 == null) return

    complementMap.add(target - node1.`val`)
    mapComplements(node1.left, target)
    mapComplements(node1.right, target)
}

