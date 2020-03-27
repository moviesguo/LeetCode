package com.moviesguo.algorithm.tree

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *   2
 *  / \
 * 1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *      3
 *       \
 *       30
 *     /
 *    10
 *     \
 *     15
 *      \
 *      45
 *
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 */

fun main() {
    val root = TreeNode()
    val left = TreeNode()
    val right = TreeNode()
    root.`val` = 3
    left.`val` =1
    right.`val` = 5
    root.left = left
    root.right = right

    val leftLeft = TreeNode()
    leftLeft.`val` = 0
    val leftRight = TreeNode()
    leftRight.`val` = 2
    var leftRightRight = TreeNode()
    leftRightRight.`val` = 3
//    leftRight.right = leftRightRight

    left.left = leftLeft
    left.right = leftRight

    var rightLeft = TreeNode()
    var rightRight = TreeNode()
    rightLeft.`val` = 4
    rightRight.`val` = 6
    right.left = rightLeft
    right.right = rightRight
    println(isValidBST(root))
}

fun isValidBST(root: TreeNode?): Boolean {

    if (root == null) return true
    if (isValidBSTLeft(root.left, root.`val`)) return false
    if (isValidBSTRight(root.right, root.`val`)) return false
    return true
//    return helper(root,null,null)
}

fun helper(root: TreeNode?, lower: Int?, upper: Int?):Boolean {
    if (root ==null) return true
    var value = root.`val`

    println("value : $value lower $lower upper : $upper")

    if (lower != null && value <= lower) return false
    if (upper != null && value >= upper) return false
    // 对于右节点来说,一定会比自身大,且会比upper小,如果是在一直右子树的情况下,upper一直未null
    // 当转移到一个左子树时,这时上限就是转移时的val,如果比他还大的话就不能构成二叉搜索树,左节点同理
    // 不需要考虑一直左走和一直右走的问题,如果出现问题直接在上面的条件就返回了
    if (!helper(root.right, value, upper)) return false
    if (!helper(root.left, lower, value)) return false
    return true
}



fun isValidBSTLeft(root: TreeNode?, compareVal: Int): Boolean {
    if (root == null) return true
    if (root.left?.`val` ?: Int.MIN_VALUE >= root.`val` || root.right?.`val` ?: Int.MAX_VALUE <= root.`val`
            || root.left?.`val` ?: Int.MIN_VALUE >= compareVal) return false
    if (!isValidBSTLeft(root.left, compareVal)) return false
    if (!isValidBSTRight(root.right, root.`val`)) return false
    return true
}



fun isValidBSTRight(root: TreeNode?, compareVal: Int): Boolean {
    if (root == null) return true
    if (root.left?.`val` ?: Int.MIN_VALUE >= root.`val` || root.right?.`val` ?: Int.MAX_VALUE <= root.`val`
            || root.right?.`val` ?: Int.MAX_VALUE <= compareVal)return false
    if (!isValidBSTLeft(root.left, compareVal)) return false
    if (!isValidBSTRight(root.right, root.`val`)) return false
    return true
}