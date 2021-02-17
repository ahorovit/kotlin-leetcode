/*
https://leetcode.com/problems/validate-binary-search-tree/
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

 */

var prev: Int? = null

fun isValidBST(root: TreeNode?): Boolean {
    if (root == null) return true

    val leftRes = isValidBST(root.left)
    val curRes = prev?.let { root.`val` > it } ?: true
    prev = root.`val`
    val rightRes = isValidBST(root.right)

    return leftRes && curRes && rightRes
}