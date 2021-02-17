
fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return if (nums.isEmpty()) {
        null
    } else {
        getChild(nums, 0, nums.size-1)
    }
}


fun getChild(nums: IntArray, min: Int, max: Int) : TreeNode
{
    val child: TreeNode

    when {
        min == max -> {
            child = TreeNode(nums[min])
            return child
        }
        min+1 == max -> {
            child = TreeNode(nums[max])
            child.left = getChild(nums, min, min)
            return child
        }
        else -> {
            val midIndex = (min + max) / 2
            child = TreeNode(nums[midIndex])
            child.left = getChild(nums, min, midIndex-1)
            child.right = getChild(nums, midIndex+1, max)
        }
    }

    return child
}






 class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
 }