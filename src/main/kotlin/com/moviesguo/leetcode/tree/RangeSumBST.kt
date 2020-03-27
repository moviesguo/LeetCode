package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 * 提示：
 *
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 *
 */
var ans = 0
fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
    if (root == null) return 0
    if (root.`val` in L..R) ans += root.`val`
    if (root.`val` > L) rangeSumBST(root.left, L, R)
    if (root.`val` < R) rangeSumBST(root.right, L, R)
    return ans
}

//fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
//    if (root == null) return 0
//    rangeSumBST(root.left,L,R)
//    if (root.`val` in L..R) ans += root.`val`
//    rangeSumBST(root.right,L,R)
//    return ans
//}