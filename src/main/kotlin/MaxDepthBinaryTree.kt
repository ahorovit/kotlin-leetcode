/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 */

import kotlin.math.max

fun maxDepth(root: TreeNode?): Int {
    return findMax(root, 0)
}

fun findMax(root: TreeNode?, parentDepth: Int): Int {
    return when {
        root == null -> parentDepth
        else -> max(
            findMax(root.left, parentDepth+1),
            findMax(root.right, parentDepth+1)
        )
    }
}
