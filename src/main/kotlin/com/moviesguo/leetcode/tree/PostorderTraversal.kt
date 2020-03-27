package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *      1
 *      \
 *       2
 *      /
 *     3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
fun postorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val ans = LinkedList<Int>()
    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        //根右左的方式遍历 然后倒序加入到list里面就是左右根
        //所以这里先入栈左节点再入栈右节点
        val node = stack.pop()
        ans.add(0, node.`val`)
        if (node.left != null) {
            stack.push(node.left)
        }
        if (node.right != null) {
            stack.push(node.right)
        }
    }
    return ans
}

fun postFoo(root:TreeNode?):List<Int>{
    if (root == null) return emptyList()
    val ans = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    val set = HashSet<TreeNode>()
    var cur = root
    while (stack.isNotEmpty() || cur != null) {
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
        cur = stack.peek()
        //如果当前节点的右子树为空，或者是第二次到这个节点，那么左右都是遍历完了，可以加入根系欸但了
        if (cur.right == null || set.contains(cur)) {
            //加入根节点
            ans.add(cur.`val`)
            //set里面加入自己，这里好下岗可以不加
            set.add(cur)
            //出栈
            stack.pop()
            //可能到这里是root节点，弹出就没了
            if (stack.isEmpty()) return ans
            //再去看父节点的右节点
            cur = stack.peek()
            cur = cur.right
        } else {
            //如果是第一次访问这个节点，先加入set表示已经来过这一次
            set.add(cur)
            //然后再去看看右节点
            cur = cur.right
        }
    }
    return ans

}