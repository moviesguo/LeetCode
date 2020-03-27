package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import com.moviesguo.algorithm.tree.buildTree

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *      1
 *     / \
 *    2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 */

fun main() {

    val preorder = intArrayOf(1,2,4,5,3,6)
    val inorder = intArrayOf(4,2,5,1,6,3)
    val tree = buildTree(preorder, inorder)
    println(countNodes(tree))
}

fun countNodes(root: TreeNode?): Int {
    if (root == null) return 0
    //左子树高度
    val leftHeight = countHeight(root.left)
    //右子树高度  两个子树的最左节点就能知道两个子树的高度差，利用这一点做的二分
    val rightHeight = countHeight(root.right)
    //如果左子树比右子树高1，说明右子树最后一层没有叶子节点
    return if (leftHeight - rightHeight == 1) {
        //所以就去计算左子树节点数 + 右子树的满二叉树节点数为 2*rightHeight - 1 再加上根节点
        // countNodes(root.left) 左子树的节点数 + (1 shl rightHeight) - 1 右节点个数 + 1 根节点
        countNodes(root.left) + (1 shl rightHeight)
    } else {
        //如果高度相同，那么左子树是完全二叉树
        // （1 shl leftHeight) - 1 //到这里是除去根节点左子树的个数 + 1 //根节点 + count(root.right) //右节点
        (1 shl leftHeight) + countNodes(root.right)
    }
}

fun countHeight(root: TreeNode?):Int {
    var height = 0
    var cur = root
    while (cur != null) {
        cur = cur.left
        height++
    }
    return height
}
