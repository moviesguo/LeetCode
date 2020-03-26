package tree

import TreeNode
import buildTree
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashMap

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *     3
 *    / \
 *   4   5
 * / \   \
 * 1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 */
fun main() {

    val root = TreeNode(3)
    val node1 = TreeNode(4)
    val node2 = TreeNode(5)
    val node3 = TreeNode(1)
    val node4 = TreeNode(3)
    val node5 = TreeNode(1)
    root.left = node1
    root.right = node2
    node1.left = node3
    node1.right = node4
    node2.right = node5

    println(rob(root))
}

/**
 * root节点能偷到的最多钱情况：
 * 1. 自身+4个可能存在的孙子节点的钱
 * 2. 两个儿子节点的钱
 */
fun rob(root: TreeNode?): Int {
    if (root==null) return 0
    var moneny = root.`val`
    if (root.left != null) {
        moneny += (rob(root.left?.left) + rob(root.left?.right))
    }
    if (root.right != null) {
        moneny += (rob(root.right?.left) + rob(root.right?.right))
    }

    return moneny.coerceAtLeast(rob(root.left) + rob(root.right))
}
/**
 * 思路是最多的钱等于左节点偷+右节点偷或者左右都不偷能偷到的钱+自身
 */
fun helper(root:TreeNode?):IntArray{
    if (root==null) return intArrayOf(0, 0)
    val result = IntArray(2)
    val left = helper(root.left)
    val right = helper(root.right)
    //左孩子能偷到的最多的钱+右孩子能偷到的最多的钱,自己不偷
    result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1])
    //左右孩子都不偷的钱+自己偷的钱 left[0] 就是左孩子自己不偷的情况
    result[1] = left[0] + right[0] + root.`val`
    return result
}
