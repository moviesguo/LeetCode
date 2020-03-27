package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *        10
 *       /  \
 *      5   -3
 *     / \    \
 *    3   2   11
 *   / \   \
 *  3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 */

fun main() {
    val root = TreeNode(10)
    val node1 = TreeNode(5)
    val node2 = TreeNode(3)
    val node3 = TreeNode(3)
    val node4 = TreeNode(-2)
    val node5 = TreeNode(2)
    val node6 = TreeNode(1)
    val node7 = TreeNode(-3)
    val node8 = TreeNode(11)
    root.left = node1
    node1.left = node2
    node2.left = node3
    node2.right = node4
    node1.right = node5
    node5.right = node6
    root.right = node7
    node7.right = node8
    println(pathSum(root, 8))
}

fun pathSum(root: TreeNode?, sum: Int): Int {
    var intArray = IntArray(0)
    return helper(root, sum, intArray)
}

var num = 0

fun foo(root: TreeNode?, sum: Int): Int {
    if (root == null) return num
    if (sum - root.`val` == 0) num++
    foo(root.left, sum - root.`val`)
    foo(root.right, sum - root.`val`)
    return num
}

/**
 * 大体思路是记录下来之前的路径所需要的值
 * 然后每次去判断是否与之前记录的值有相等，有就+1
 * 之后再去更新记录的值
 */
fun helper(root: TreeNode?, sum: Int, need: IntArray): Int {
    if (root == null) return 0
    val newNeed = IntArray(need.size + 1)
    var count = if (root.`val` == sum) 1 else 0
    for (index in need.indices) {
        if (need[index] == root.`val`) {
            count++
        }
        newNeed[index] = need[index] - root.`val`
    }
    newNeed[newNeed.lastIndex] = sum - root.`val`
    count += helper(root.left, sum, newNeed)
    count += helper(root.right, sum, newNeed)
    return count
}

