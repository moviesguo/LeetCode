package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *      1
 *    /  \
 *  2     3
 *   \
 *    5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */

val binaryAns = ArrayList<String>()

fun binaryTreePaths(root: TreeNode?): List<String> {
    if (root == null) return emptyList()
    binaryTreeHelper(root, "")
    return binaryAns
}


fun binaryTreeHelper(root: TreeNode, sub:String){
    if (root.left == null && root.right == null){
        binaryAns.add("$sub${root.`val`}")
        return
    }
    if (root.left!=null) binaryTreeHelper(root.left!!, "$sub${root.`val`}->")
    if (root.right!=null) binaryTreeHelper(root.right!!, "$sub${root.`val`}->")
}