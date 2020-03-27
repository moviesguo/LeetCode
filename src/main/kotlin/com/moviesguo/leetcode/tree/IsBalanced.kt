package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import java.util.*
import kotlin.math.abs
import kotlin.math.max

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *          1
 *         / \
 *       2   2
 *      / \
 *     3   3
 *    / \
 *   4   4
 * 返回 false 。
 */
fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true
    val left = isBalancedHelper(root.left)
    val right = isBalancedHelper(root.right)
    return abs(left - right) < 2 && isBalanced(root.left) && isBalanced(root.right)
}

/**
 * 暴力法，每层+1然后对比每个节点的左右，从顶到下，这就很浪费的多了很多次递归
 */
fun isBalancedHelper(root: TreeNode?): Int {
    if (root == null) return 0
    val left = isBalancedHelper(root.left)
    val right = isBalancedHelper(root.right)
    return (if (left > right) left else right) + 1
}

fun isBalancedDFSMain(root:TreeNode?):Boolean {
    return isBalancedDFS(root) != -1
}

/**
 * 左右查，每层+1,如果某一层左右之差大于2，那么直接截断递归并返回-1
 */
fun isBalancedDFS(root: TreeNode?): Int {
    if (root == null) return 0
    val left = isBalancedDFS(root.left)
    if (left == -1) return -1
    val right = isBalancedDFS(root.right)
    if (right == -1) return -1
    return if (abs(left - right) < 2) max(left, right) else -1
}