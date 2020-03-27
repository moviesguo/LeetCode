package com.moviesguo.leetcode.tree


import com.moviesguo.algorithm.tree.TreeNode
import com.moviesguo.algorithm.tree.buildTree

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  0
 *  /  \    / \
 * 7    2  9   10
 * 返回:
 *
 * [
 * [5,4,11,2],
 * [5,8,0,9]
 * ]
 *
 */

val result = ArrayList<List<Int>>()

fun main() {
    val preorder = intArrayOf(5, 4, 11, 7, 2, 8, 13, 0, 9, 1)
    val inorder = intArrayOf(7, 11, 2, 4, 5, 13, 8, 9, 0, 1)
    val tree = buildTree(preorder, inorder)
    println(pathSum2(tree, 22))
}

/**
 * 回溯法，如果到了叶子节点没有找到合适的就返回并且删除最后一个
 * 找到了就加入结果中
 */
fun pathSum2(root: TreeNode?, sum: Int): List<List<Int>> {
    if (root == null) return result
    sub.add(root.`val`)
    if (root.left == null && root.right == null && root.`val` == sum) {
        result.add(ArrayList(sub))  //记得拷贝一份
    }
    if (root.left != null) {
        pathSum2(root.left!!, sum - root.`val`)
    }
    if (root.right != null) {
        pathSum2(root.right!!, sum - root.`val`)
    }
    sub.removeAt(sub.size - 1)
    return result
}

val sub = ArrayList<Int>()

fun pathSumHelper(root: TreeNode,sum: Int){


}