package com.moviesguo.algorithm.tree

import java.util.*

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3  4   6
 * 将其展开为：
 *
 *  1
 *   \
 *   2
 *    \
 *    3
 *     \
 *     4
 *      \
 *      5
 *       \
 *       6
 *
 */

/**
 * @author 很菜的Android程序员
 * 啊我好菜啊
 */
fun main() {
    var pre = intArrayOf(1, 2, 3, 4, 5,6)
    var `in` = intArrayOf(3, 2, 4, 1, 5,6)
    var root = buildTree(pre, `in`)
    flatten(root)
}


/**
 * 后序遍历(右左中),然后每次记录上一个节点,再讲本次节点的右节点指向上一个节点就好了
 *
 */
//fun flatten(root: TreeNode?): Unit {
//    if (root == null) return
//    flatten(root.right)
//    flatten(root.left)
//    root.right = pre
//    pre = root
//}

/**
 *
 * 利用栈实现了前序遍历
 * 1 -> 进栈
 * 1 -> 出栈 pre = 1
 * 5,2 -> 进栈
 * 2 -> 出栈  1右节点为2  pre =2
 * 4,3 -> 进栈
 * 3 ->  出栈 2右节点为3 pre =3
 * 4 -> 出栈 3右节点为4  pre = 4
 * 5 -> 出栈 4右节点为5  pre = 5
 * 6 -> 进栈
 * 6 -> 出栈 5右节点为6 pre = null
 *
 * 利用栈实现前序遍历的思路
 *
 * ps:假设根节点已经压栈
 *
 * 栈是先进先出的数据结构,所以先将右节点压栈,再将左节点压栈
 * 这个时候先出栈的就会是左节点,之后再对左节点的右节点,左节点的左节点依次压栈,如此循环就是前序遍历了
 *
 */
fun flatten(root: TreeNode?): Unit {

    val stack = Stack<TreeNode>()
    var temp = root
    var pre: TreeNode? = null
    stack.push(root)
    while (!stack.isEmpty()) {
        temp = stack.pop()
        var message = temp.`val`
        if (pre != null) {
            pre.right = temp
            pre.left = null
        }
        println("temp : ${temp.`val`} pre : ${pre?.`val`} ")

        if (temp?.right!=null ){
            stack.push(temp.right)
        }

        if (temp?.left != null) {
            stack.push(temp.left)
        }
        pre = temp
    }

}
