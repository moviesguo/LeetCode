package tree

import TreeNode
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sign

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 *
 */
fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    if (root==null) return emptyList()
    val result = LinkedList<MutableList<Int>>()
    var stack = LinkedList<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        val sub = ArrayList<Int>()
        val trees = ArrayList<TreeNode>()
        while (stack.isNotEmpty()) {
            val tree = stack.pop()
            trees.add(tree)
            sub.add(tree.`val`)
        }
        result.add(0, sub)
        trees.forEach {
            if (it.left != null) stack.offer(it.left)
            if (it.right != null) stack.offer(it.right)
        }
    }
    return result
}

val res = LinkedList<MutableList<Int>>()


fun levelOrderBottomHelper(root: TreeNode?, level:Int) {
    if (root == null) return
    val sub = if (level >= res.size) {
        val arrayList = ArrayList<Int>()
        res.add(0,arrayList)
        //这里是因为如果还是返回添加的arrayList的话，左子树没有问题，右子树会添加到左子树添加的第一个arrayList中
        //所以 res.size - 1 - level 才是对应的逆序时的索引
       res[res.size - 1 - level]
    } else {
        res[res.size - 1 - level]
    }
    sub.add(root.`val`)

    if (root.left!=null) levelOrderBottomHelper(root.left, level + 1)
    if (root.right!=null) levelOrderBottomHelper(root.right, level + 1)
}
