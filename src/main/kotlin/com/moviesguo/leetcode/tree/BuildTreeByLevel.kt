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
    val nums = list.toTypedArray()
    println(buildTreeByLevel(nums))
}

fun buildTreeByLevel(nums: Array<Int?>):TreeNode {

    val root = TreeNode(nums[0]!!)
    val queue = LinkedList<TreeNode>()
    queue.push(root)
    var i = 1
    while (i>=nums.size){
        val sub = ArrayList<TreeNode>()
        while (queue.isNotEmpty()) {
            sub.add(queue.pop())
        }
        sub.forEach {

            val left = if (nums[i++] == null) null else
                TreeNode(nums[i]!!)
            val right = if (nums[i++] == null) null else
                TreeNode(nums[i]!!)
            queue.push(left)
            queue.push(right)
            it.left = left
            it.right = right
        }

    }
    return root
}