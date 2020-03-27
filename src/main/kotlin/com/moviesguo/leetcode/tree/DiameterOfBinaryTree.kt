package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import com.moviesguo.algorithm.tree.buildTree

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *       1
 *      / \
 *     2   3
 *   / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */

var length = 0

fun main() {
    val pre = intArrayOf(1,2,4,5,6,3,7)
    val inorder = intArrayOf(4, 2, 6,5, 1, 3,7)
    val tree = buildTree(pre, inorder)
    println(diameterOfBinaryTree(tree))
}

fun diameterOfBinaryTree(root: TreeNode?): Int {
    length = 1
    depth(root)
    println("length $length")
    return length - 1
}

/**
 * 遍历一遍树，然后左子树+右子树的最大的节点就是直径了
 * 可能存在 不经过root节点的最大直径，所以length要比较每次节点的左+右和自身
 */
fun depth(root: TreeNode?): Int {
    if (root == null) return 0
    val left = depth(root.left)
    val right = depth(root.right)
    length = Math.max(length, (left + right + 1))
    println("depth length $length")
    return Math.max(left, right) + 1
}


