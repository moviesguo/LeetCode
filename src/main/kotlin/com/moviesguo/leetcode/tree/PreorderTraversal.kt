package tree

import TreeNode
import java.util.*
import kotlin.collections.ArrayList


/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *   1
 *    \
 *    2
 *   /
 * 3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
fun preorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val ans = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    var cur = root
    while (stack.isNotEmpty() || cur != null) {
        while (cur != null) {
            ans.add(cur.`val`)
            stack.push(cur)
            cur = cur.left
        }
        cur = stack.pop()
        cur = cur.right
    }
    return ans
}

fun foo(root:TreeNode?):List<Int>{
    if (root == null) return emptyList()
    val ans = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        //先加入根节点，再右左这样入栈，遍历出来就是根左右
        val node = stack.pop()
        ans.add(node.`val`)
        if (node.right != null) {
            stack.push(node.right)
        }
        if (node.left != null) {
            stack.push(node.left)
        }
    }
    return ans
}