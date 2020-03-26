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
 *       3
 *      / \
 *     9  20
 *       /  \
 *     15   7
 *
 */

fun main() {
    val preorder = intArrayOf(3,9,20,15,7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)
    buildTree(preorder,inorder)
}

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {


    var split = 0
    for (i in 0 until inorder.size) {
        println("i $i")
        if (inorder[i] == preorder[0]){
            split = i
            break
        }
    }
    return buildLeftSubTree(preorder,inorder,0,split)
}

fun buildLeftSubTree(preorder: IntArray, inorder: IntArray, rootIndex:Int,split:Int): TreeNode?{
    if (rootIndex == -1) return null

    var s = -1
    val root = TreeNode()
    root.`val` = preorder[rootIndex]

    for (i in 0 until split) {
        s = if (preorder[rootIndex] == inorder[i]) i else continue
    }
    println("左子树分割结果$s")
    root.left = buildLeftSubTree(preorder, inorder, rootIndex + 1,s)
    root.right = buildRightSubTree(preorder, inorder, rootIndex + 1, s)
    return root
}

fun buildRightSubTree(preorder: IntArray, inorder: IntArray, rootIndex: Int,split:Int): TreeNode? {
    if (rootIndex == -1) return null

    var s = -1
    val root = TreeNode()
    root.`val` = preorder[rootIndex]

    if (rootIndex == 0){
        println("右子树最后一个 ${preorder[rootIndex]}")
        return root
    }

    for (i in split + 1 until inorder.size) {
        s = if (preorder[rootIndex] == inorder[i]) i else continue
    }
    println("右子树分割结果$s")
    root.left = buildLeftSubTree(preorder, inorder, rootIndex + 1,s)
    root.right = buildLeftSubTree(preorder, inorder, rootIndex + split + 1,s)
    return root
}