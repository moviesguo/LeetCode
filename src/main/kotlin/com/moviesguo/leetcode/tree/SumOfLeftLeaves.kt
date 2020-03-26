package tree

import TreeNode

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 */
fun sumOfLeftLeaves(root: TreeNode?): Int {
    if(root == null) return 0
    sumOfLeftLeaves(root.left, true)
    sumOfLeftLeaves(root.right, false)
    return leftSum
}

var leftSum = 0

fun sumOfLeftLeaves(root:TreeNode?,isLeft:Boolean){
    if (root==null) return
    if (root.left == null && root.right == null && isLeft) {
        leftSum += root.`val`
    } else {
        sumOfLeftLeaves(root.left, true)
        sumOfLeftLeaves(root.right,false)
    }
}

//直接在上一层判断，减少一个控制变量的使用
fun sumOfLeftLeavesHelper(root: TreeNode?): Int {
    if (root == null) return 0
    if (root.left != null && root.left!!.left == null && root.left!!.right == null) {
        leftSum += root.left!!.`val`
    }
    sumOfLeftLeavesHelper(root.left)
    sumOfLeftLeavesHelper(root.right)
    return sum
}