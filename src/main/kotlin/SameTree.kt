/*
https://leetcode.com/problems/same-tree/

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    return when {
        p == null && q == null -> true
        p == null || q == null -> false
        p.`val` != q.`val` -> false
        else -> isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}

