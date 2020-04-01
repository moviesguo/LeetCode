package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import sun.reflect.generics.tree.Tree
import java.util.*
import kotlin.math.max

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *      2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *      1
 *     / \
 *    2   3
 *   /   / \
 * 4   5   6
 * /
 * 7
 *
 * 输出:
 * 7
 *  
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 */
fun findBottomLeftValue(root: TreeNode?): Int {
    if (root == null) return 0
    findBottomLeftValueRecursive(root,0)
    return left?.`val` ?: 0
}

var maxLevel = -1
var left :TreeNode? = null

//中序遍历，记录一个层级，每次到下一层的时候都更新一下left
//还可以层序遍历，用队列，每次出队的第一个就是left，然后循环完了指向的node就是left了
fun findBottomLeftValueRecursive(root: TreeNode, level: Int) {
    if (root.left == null && root.right == null){
        if (level > maxLevel) {
            maxLevel = level
            left = root
        }
        return
    }
    if (root.left != null) {
        findBottomLeftValueRecursive(root.left!!, level + 1)
    }

    if (root.right != null) {
        findBottomLeftValueRecursive(root.right!!, level + 1)
    }

}