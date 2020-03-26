package tree

import TreeNode
import buildTree
import java.util.*
import kotlin.collections.ArrayList

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 */
fun main() {
    val pre = intArrayOf(3,9,20,15,7)
    val inorder = intArrayOf(9,3,15,20,7)
    val buildTree = buildTree(pre, inorder)
    println(zigzagLevelOrder(buildTree))

}

/**
 * 用栈实现先进后出操作本就是一个梯形
 * 3- 9进 20进
 * 20出 17进 15 进 9出
 * 15出  17出
 * 只需要控制每层的节点左右先进就可以了
 */
fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return ArrayList()
    val stack = Stack<TreeNode>()
    stack.push(root)
    val result = ArrayList<List<Int>>()
    var fromLeft = true
    while (stack.isNotEmpty()) {
        val sub = ArrayList<Int>()
        val temp = ArrayList<TreeNode>()
        while (stack.isNotEmpty()) {
            temp.add(stack.pop())
        }
        for (treeNode in temp) {
            sub.add(treeNode.`val`)
            if (fromLeft) {
                if (treeNode.left != null) stack.push(treeNode.left)
                if (treeNode.right != null) stack.push(treeNode.right)
            } else {
                if (treeNode.right != null) stack.push(treeNode.right)
                if (treeNode.left != null) stack.push(treeNode.left)
            }
        }
        fromLeft = !fromLeft
        result.add(sub)
    }
    return result
}

fun zigzagLevelOrderHelper(root: TreeNode?){

}