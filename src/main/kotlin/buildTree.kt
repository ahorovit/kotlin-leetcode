//class TreeBuilderI() {
//    lateinit var preorder: IntArray
//    var preOrderIdx = 0
//    val inOrderMap = HashMap<Int, Int>()
//
//
//    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
//        this.preorder = preorder
//
//        for ((index, value) in inorder.withIndex()) {
//            inOrderMap[value] = index
//        }
//
//        return buildSubTree(0, inorder.size)
//    }
//
//    fun buildSubTree(left: Int, right: Int): TreeNode? {
//
//        if (left == right) return null
//
//        val rootVal = preorder[preOrderIdx]
//        val index: Int = inOrderMap[rootVal]!!
//        val root = TreeNode(rootVal)
//
//        preOrderIdx++
//        root.left = buildSubTree(left, index)
//        root.right = buildSubTree(index + 1, right)
//
//        return root
//    }
//}

fun main() {
    val builder = TreeBuilderII()
    builder.buildTree(
        intArrayOf(9,3,15,20,7),
        intArrayOf(9,15,7,20,3)
    )
}


class TreeBuilderII() {
    var postOrder = intArrayOf()
    var postOrderIdx = -1
    val inOrderMap = HashMap<Int, Int>()


    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        this.postOrder = postorder
        postOrderIdx = postorder.size - 1

        for ((index, value) in inorder.withIndex()) {
            inOrderMap[value] = index
        }

        return buildSubTree(0, inorder.size)
    }

    fun buildSubTree(left: Int, right: Int): TreeNode? {
        if (left == right) return null

        val rootVal = postOrder[postOrderIdx]
        val index: Int = inOrderMap[rootVal]!!
        val root = TreeNode(rootVal)

        postOrderIdx--
        root.right = buildSubTree(index+1, right)
        root.left = buildSubTree(left, index)

        return root
    }
}



