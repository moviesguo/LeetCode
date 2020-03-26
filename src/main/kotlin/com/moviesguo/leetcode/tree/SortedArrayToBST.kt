package tree

import TreeNode

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *        0
 *       / \
 *     -3   9
 *     /   /
 *   -10  5
 *
 */

fun main() {
    val nums = intArrayOf(-10, -3, 0, 5, 9)
    println(sortedArrayToBST(nums))
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) return null
    return helper(nums,0,nums.size -1)
}

/**
 * 普通的二分法，需要考虑奇偶的问题，如果是偶数的时候应该选择更大的一个数也就是索引+1的数作为根节点继续递归
 */
fun helper(nums: IntArray, start: Int, end: Int) :TreeNode?{
    if (start == end) return TreeNode(nums[start])
    var min = (end - start) / 2 + start
//    if ((end - start + 1) % 2 == 0) min += 1
    val node = TreeNode(nums[min])
    node.left = helper(nums, start, min - 1)
    if (min + 1>end) return node
    node.right = helper(nums, min + 1, end)
    return node
}