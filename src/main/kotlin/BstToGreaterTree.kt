
fun main()
{
    val root = buildTree(arrayOf(4,1,6,0,2,5,7,null,null,null,3,null,null,null,8))

    convertBST(root)
}

fun buildTree(values: Array<Int?>): TreeNode?
{
    val tree = Array<TreeNode?>(values.size){ null }

    values.forEachIndexed { index, value ->
        if (value != null) {
            tree[index] = TreeNode(value)
            val parentIndex = (index - 1) / 2

            if (parentIndex >= 0) {
                if (index % 2 == 0) {
                    tree[parentIndex]?.right = tree[index]
                } else {
                    tree[parentIndex]?.left = tree[index]
                }
            }
        }
    }

    println("INPUT: ${tree.map { it?.`val` }}")

    return tree[0]
}

var greaterSum = 0

fun convertBST(root: TreeNode?): TreeNode? {
    if (root == null) {
        return root
    }

    convertBST(root.right)
    greaterSum += root.`val`
    root.`val` = greaterSum
    convertBST(root.left)

    return root
}



//fun convertBST(root: TreeNode?): TreeNode? {
//    getSubTreeSum(root)
//    return root
//}
//
//fun getSubTreeSum(node: TreeNode?, greaterSum: Int? = null): Int {
//    if (node == null) {
//        return 0
//    }
//
//    val rSum = getSubTreeSum(node.right) + (greaterSum ?: 0)
//    val lSum = getSubTreeSum(node.left, node.`val` + rSum)
//
//    node.`val` += rSum
//
//    return if (node.left == null) {
//        node.`val`
//    } else {
//        lSum
//    }
//}

