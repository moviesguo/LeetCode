package tree

import TreeNode
import buildNormalTree
import buildTree

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *       4
 *     /   \
 *    7     2
 *  / \    / \
 * 9   6  3   1
 *
 */
fun main() {
    val pre = intArrayOf(4,2,1,3,7,6,9)
    val inorder = intArrayOf(1, 2, 3, 4, 6, 7, 9)
    val tree = buildTree(pre, inorder)
    println(tree)
    val invertTree = invertTree(tree)
    println(invertTree)
}

fun invertTree(root: TreeNode?): TreeNode? {
    root ?: return null
    val right = invertTree(root.right)
    val left = invertTree(root.left)

    root.right = left
    root.left = right
    return root
}