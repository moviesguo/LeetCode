package com.moviesguo.algorithm.tree

import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 *
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */

fun main() {
    var root = TreeNode()
    root.`val` = 1
    var left = TreeNode()
    left.`val` = 3
    var right = TreeNode()
    right.`val` = 2
    root.right = right
    right.left = left
    println(recursiveInorderTraversal(root))
}

/**
 * 迭代版本
 *
 * 栈真是个好东西
 *       1
 *     /   \
 *    2    3
 *  /  \   /
 * 4   3  6
 *    图（1）
 *
 * 按照图（1）的树来说,代码运行的顺序应该是：
 *
 *  1 -> 压栈
 *  2 -> 压栈
 *  4 -> 压栈
 *  4 -> 出栈
 *  res.add(4)
 *  curr = 4.right
 *  循环时curr为null
 *  2 -> 出栈
 *  res.add(2)
 *  curr = 2.right
 *  5 -> 压栈
 *  5 -> 出栈
 *  curr = 5.right
 *  到这就差不多了
 */
fun inorderTraversal(root: TreeNode?): List<Int> {

    var res = ArrayList<Int>()
    var stack = Stack<TreeNode>()
    var curr = root

    //root.left为空时可能栈中还有未遍历的节点
    while (curr?.left != null || !stack.isEmpty()) {
        //先将所有左节点压栈
        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }
        curr = stack.pop()
        res.add(curr.`val`)
        curr = curr.right
    }


    return arrayListOf()
}

/**
 * 递归版本
 */
fun recursiveInorderTraversal(root: TreeNode?): List<Int> {
    var list = ArrayList<Int>()
    recursiveInorderTraversal(root, list)
    return list
}

fun recursiveInorderTraversal(root: TreeNode?, list:MutableList<Int>){
    if (root==null) return
    list.add(root.`val`)
    recursiveInorderTraversal(root.left, list)
    recursiveInorderTraversal(root.right, list)
}