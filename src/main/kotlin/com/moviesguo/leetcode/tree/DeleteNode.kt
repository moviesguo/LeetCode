package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import com.moviesguo.algorithm.tree.buildTree

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *      5
 *     / \
 *    3   6
 *   / \   \
 *  2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *   \   \
 *    4   7
 */

fun main() {
    val pre = intArrayOf(5, 3, 2, 4, 6, 7)
    val inorder = intArrayOf(2, 3, 4, 5, 6, 7)
    val buildTree = buildTree(pre, inorder)
    val deleteNode = deleteNode(buildTree, 3)
    println(deleteNode)

}
fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) return root
    if (root.`val` < key ) root.right = deleteNode(root.right, key)
    else if (root.`val` > key) root.left = deleteNode(root.left, key)
    else {
        when {
            root.right != null -> {
                //找到之后把自己的值设置为successor
                val successor = findMin(root)
                root.`val` = successor
                //然后删除它
                root.right = deleteNode(root.right, root.`val`)
            }
            root.left != null -> {
                //predecessor
                root.`val` = findMax(root)
                //然后删除它
                root.left = deleteNode(root.left, root.`val`)
            }
            else -> {
                return null
            }
        }
    }
    return root
}

//寻找比自己大的数中最小的数
// successor
fun findMin(root:TreeNode):Int{
    var cur = root.right
    while (cur?.left != null) {
        cur = cur.left
    }
    return cur!!.`val`
}
//寻找比自己小的数中最大的数
// predecessor
fun findMax(root:TreeNode):Int{
    var cur = root.left
    while (cur?.right != null) {
        cur = cur.right
    }
    return cur!!.`val`
}

