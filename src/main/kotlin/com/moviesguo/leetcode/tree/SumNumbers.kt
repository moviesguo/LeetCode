package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *      1
 *     / \
 *    2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *          4
 *         / \
 *        9   0
 *      / \
 *     5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 */

val subNumbersResult = ArrayList<Int>()
var subNums = 0
fun sumNumbers(root: TreeNode?): Int {
    if (root == null) return 0
    sumNumbers(root, 0)
    return subNums
}

/**
 * 将父节点的计算结果传下去，然后再加上当前的，如果为叶子节点就直接加到结果里面
 * 如果不是继续递归
 */
fun sumNumbers(root: TreeNode, sum: Int) {
    val subSum = sum * 10 + root.`val`
    if (root.left == null && root.right == null) {
        subNums += subSum
        return
    }
    if (root.left != null) sumNumbers(root.left!!, subSum)
    if (root.right != null) sumNumbers(root.right!!, subSum)
}
