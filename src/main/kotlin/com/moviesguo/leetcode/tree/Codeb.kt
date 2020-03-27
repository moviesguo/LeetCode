package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode
import com.moviesguo.algorithm.tree.buildTree
import java.util.*


/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
 * 或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 */

fun main() {
    val pre = intArrayOf(8,3,1,6,4,7,10,13,14)
    val inorder = intArrayOf(1,3,4,6,7,8,10,13,14)
    val root = buildTree(pre, inorder)
    val a = Codeb()
    val serialize = a.serialize(root)
    val deserialize = a.deserialize(serialize)
    println(serialize)
}

class Codeb {



    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {


        if (root == null) return ""
        val sb = StringBuilder()
        val stack = Stack<TreeNode>()
        var cur = root
        while (cur != null || stack.isNotEmpty()) {
            while (cur != null) {
                sb.append("${cur.`val`}-")
                stack.push(cur)
                cur = cur.left
            }
            val node = stack.pop()
            cur = node.right
        }
        val s = sb.toString()
        return s.substring(0, s.length - 1)
    }



    // Decodes your encoded data to tree.

    /**
     * 二叉搜索树的中序遍历，8,3,1,6,4,7,10,13,14
     * 这样的结果我们可以先拿第一个，然后去后面找比当前值大的，就是右子树，然后不断地递归
     */
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val split = data.split("-")
        return convertToBST(split.toTypedArray(), 0, split.size - 1)
    }
    private fun convertToBST(arr: Array<String>, lo: Int, hi: Int): TreeNode? {
        if (lo > hi) return null
        val root = TreeNode(Integer.valueOf(arr[lo]))
        //找到第一个比首元素大的元素位置
        var index = hi + 1
        for (i in lo + 1..hi) {
            if (Integer.valueOf(arr[i]) > root.`val`) {
                index = i
                break
            }
        }
        //递归构建子树
        root.left = convertToBST(arr, lo + 1, index - 1)
        root.right = convertToBST(arr, index, hi)
        return root
    }
//    fun convertToBST(nums: List<String>, low: Int, high: Int):TreeNode? {
//        if (low > high) return null
//        val root = TreeNode(nums[low].toInt())
    //默认没有右子树
//        var index = high + 1
//        for (i in low+1..high) {
//            if (Integer.valueOf(nums[i]) > root.`val`) {
//                //找到右子树
//                index = i
//                break
//            }
//        }
//        //递归构建子树
//        root.left = convertToBST(nums, low + 1, index - 1);
//        root.right = convertToBST(nums, index, high);
//        return root;
//    }
}