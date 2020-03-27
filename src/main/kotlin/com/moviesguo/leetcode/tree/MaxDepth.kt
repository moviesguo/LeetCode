package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode


/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *   /  \
 *  9   20
 *     /  \
 *   15   7
 * 返回它的最大深度 3 。
 *
 */

fun main() {
    val root = TreeNode()
    val left = TreeNode()
    val right = TreeNode()
    root.`val` =3
    left.`val` =9
    right.`val` = 20
    root.left = left
//    root.right = right
    var rightLeft = TreeNode()
    var rightRight = TreeNode()
    rightLeft.`val` = 15
    rightRight.`val` = 7
    left.left = rightLeft
    left.right = rightRight
    rightLeft.left = right
    println(maxDepth(root))
}

fun maxDepth(root: TreeNode?): Int {
    return helper(root, 1)
}

fun helper(root: TreeNode?, level: Int):Int {
    if (root==null) return level - 1
    var max = Int.MIN_VALUE
    max = Math.max(helper(root?.left, level + 1), max)
    max = Math.max(helper(root?.right, level + 1), max)
    return max
}

