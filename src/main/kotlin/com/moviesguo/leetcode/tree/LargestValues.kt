package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *      1
 *     / \
 *    3   2
 *   / \   \
 *  5   3   9
 *
 * 输出: [1, 3, 9]
 *
 */


//层序遍历
fun largestValues(root: TreeNode?): List<Int> {
    if(root == null) return emptyList()
    val ans = ArrayList<Int>()
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    var index = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        ans.add(Int.MIN_VALUE)
        for (i in 0 until size) {
            val node = queue.pop()
            ans[index] = Math.max(ans[index], node.`val`)
            if (node.left!=null) queue.offer(node.left)
            if (node.right!=null) queue.offer(node.right)
        }
        index++
    }
    return ans
}