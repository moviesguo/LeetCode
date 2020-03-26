package com.moviesguo.algorithm.tree

/**
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *    3
 *  /  \
 * 9   20
 *    /  \
 *  15   7
 *
 */

fun main() {

    var pre = intArrayOf(3, 9, 20, 15, 7)
    var `in` = intArrayOf(9, 3, 15, 20, 7)
    var root = buildTree(pre, `in`)
}

fun buildTree2(preorder: IntArray, inorder: IntArray): TreeNode? {
    return buildTree2(preorder, inorder, 0, preorder.size, 0, inorder.size)
}

/**
 * 将in从pre[0]分为两个,这时候左右就是左右子树的中序遍历,然后再继续二分,
 * 这时候pre[0]在往后 以 in.indexOf(pre[0])分割in的左边的数量就是要递归的左子树
 */
fun buildTree2(preorder: IntArray, inorder: IntArray, pStart:Int,pEnd:Int,iStart:Int,iEnd:Int): TreeNode? {
    if (pStart == pEnd) return null
    println("pStart : $pStart pEnd : $pEnd iStart : $iStart iEnd: $iEnd")
    var mid = inorder.indexOf(preorder[pStart])
    var node = TreeNode()
    var leftNum = mid - iStart
    node.`val` = preorder[pStart]
    node.left = buildTree2(preorder, inorder, pStart + 1, pStart + leftNum + 1, iStart, mid)
    node.right = buildTree2(preorder, inorder, pStart + leftNum + 1, pEnd, mid + 1, iEnd)
    return node
}
