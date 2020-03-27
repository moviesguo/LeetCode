package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 *      Tree 1                     Tree 2
 *          1                         2
 *         / \                       / \
 *        3   2                     1   3
 *      /                           \   \
 *     5                             4   7
 * 输出:
 * 合并后的树:
 *          3
 *         / \
 *        4   5
 *      / \    \
 *     5  4    7
 * 注意: 合并必须从两个树的根节点开始。
 *
 */

fun main() {
    val root1 = TreeNode(1)
    val node1 = TreeNode(3)
    val node2 = TreeNode(2)
    val node3 = TreeNode(5)
    root1.left = node1
    root1.right = node2
    node1.left = node3

    val root2 = TreeNode(2)
    val node4 = TreeNode(1)
    val node5 = TreeNode(3)
    val node6 = TreeNode(4)
    val node7 = TreeNode(7)

    root2.left = node4
    root2.right = node5
    node4.right = node6
    node5.right = node7
    val mergeTrees = mergeTrees(root1, root2)
    println(mergeTrees)
}

fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1==null&&t2==null) return null
    val root = TreeNode((t1?.`val` ?: 0) + (t2?.`val` ?: 0))
    root.left = mergeTrees(t1?.left,t2?.left)
    root.right = mergeTrees(t1?.right, t2?.right)
    return root
}