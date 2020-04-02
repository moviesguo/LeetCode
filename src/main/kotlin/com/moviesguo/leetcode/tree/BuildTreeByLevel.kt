package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val list = ArrayList<Int?>()
    list.add(3)
    list.add(5)
    list.add(1)
    list.add(6)
    list.add(20)
    list.add(8)
    list.add(12)
    val nums = arrayOf(1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3)
    val message = buildTreeByLevel(nums)
    println(message)
}

fun buildTreeByLevel(nums: Array<Int?>):TreeNode {

    val root = TreeNode(nums[0]!!)
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    var i = 1
    while (i<nums.size){
        val sub = ArrayList<TreeNode?>()
        while (queue.isNotEmpty()) {
            sub.add(queue.pop())
        }
        sub.forEach {
            it?.let {
                val left = if (nums[i] == null) null else
                    TreeNode(nums[i]!!)
                i++
                val right = if (nums[i] == null) null else
                    TreeNode(nums[i]!!)
                i++
                queue.offer(left)
                queue.offer(right)
                it.left = left
                it.right = right
            }

        }

    }
    return root
}