package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *      1            <---
 *    /   \
 *   2     3         <---
 *    \     \
 *     5     4       <---
 *
 */
/**
 * 层序遍历，选出来最右的一个
 */
fun rightSideView(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val queue = LinkedList<TreeNode>()
    val ans = ArrayList<Int>()
    queue.push(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        ans.add(queue.last.`val`)
        for (i in 0 until size) {
            val node = queue.pop()
            if (node.left!=null) queue.add(node.left!!)
            if (node.right!= null) queue.add(node.right!!)
        }
    }
    return ans
}

val rightSideAns = ArrayList<Int>()

/**
 * 先往右遍历，如果当前的结果中还没有最新的，那么就加入当前节点
 * 这样的话，如果右节点不存，下一层就不会添加右节点，然后再去左节点找
 */
fun rightSideViewHelper(root: TreeNode?, level: Int) {
    if (root == null) return
    if (rightSideAns.size == level) rightSideAns.add(root.`val`)
    rightSideViewHelper(root.right, level + 1)
    rightSideViewHelper(root.left, level + 1)
}