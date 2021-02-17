/*
https://leetcode.com/problems/symmetric-tree/

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 */

fun isSymmetric(root: TreeNode?): Boolean {
    return when {
        root == null -> true
        else -> symSearch(root.left, root.right)
    }
}

fun symSearch(left: TreeNode?, right: TreeNode?): Boolean {
    return when {
        left == null && right == null -> true
        left == null || right == null -> false
        left.`val` != right.`val` -> false
        else -> symSearch(left.left, right.right) && symSearch(left.right, right.left)
    }
}
