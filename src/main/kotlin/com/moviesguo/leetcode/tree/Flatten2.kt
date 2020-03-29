package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import com.moviesguo.algorithm.tree.buildTree


/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *       1
 *      / \
 *     2   5
 *   / \   \
 * 3   4    6
 * 将其展开为：
 *
 *     1
 *      \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 */

fun main() {
    val preorder = intArrayOf(1,2,3)
    val inorder = intArrayOf(1,3,2)
    val root = buildTree(preorder, inorder)
    flatten(root)
    println(root)
}

/**
 *  简单思路，将左子树挪到右子树上然后铺平，继续重复这个操作
 *  写的有些蠢了
 */
fun flatten(root: TreeNode?){
    root ?: return
    if (root.left != null) {
        val temp = root.right
        root.right = root.left
        root.left = null
        flatten(root.right)
        var right = root.right
        while (right?.right != null) {
            right = right.right
        }
        flatten(temp)
        right?.right = temp
    } else {
        flatten(root.right)
        var right = root.right
        while (right?.right != null) {
            right = right.right
        }
    }
}

/**
 * 这个和上面的思路是相似的，只不过更加的清晰,更好理解
 */
fun solution(root: TreeNode?) {
    var node = root
    while (node != null) {
        if (node.left == null)
            node = node.right
        else {
            var pre = node.left
            while (pre?.right != null) {
                pre = pre.right
            }
            pre?.right = node.right
            node.right = node.left
            node.left = null
            node = node.right
        }
    }
}

/**
 * 变形后序遍历的方式，将将每个节点的右节点指向前一个节点
 * 右->左->根
 * 6 5 4 3 2 1 是变形后的后序遍历结果，所以只要记录一下上一次的节点并将当前节点指向上一次的节点就可以了
 *
 */

var pre:TreeNode? = null

fun solution1(root: TreeNode?) {
    root ?: return
    solution1(root.right)
    solution1(root.left)
    root.right = findModePre
    root.left = null
    findModePre = root
}

