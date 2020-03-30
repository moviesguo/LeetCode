package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode

/**
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 示例 1：
 * 输入:
 *
 *     5
 *   /  \
 *  2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *    5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 *
 *  
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 */
val map = HashMap<Int, Int>()
var maxCount = 1
var frequentAns = ArrayList<Int>()

fun main() {
    val root = TreeNode(5)
    val node1 = TreeNode(2)
    val node2 = TreeNode(-3)
    root.left = node1
    root.right = node2
    findFrequentTreeSum(root)
}

fun findFrequentTreeSum(root: TreeNode?): IntArray {
    findFrequentTreeSumRecursive(root)
    return frequentAns.toIntArray()
}

/**
 * 后序遍历 左中右求出来各个节点的子节点和（所有子节点的值加上自身值的和）
 * 然后用map记录出现的次数，maxCount表示目前最多出现的次数是多少
 * 根据maxCount区分是加还是清空再加
 */
fun findFrequentTreeSumRecursive(root:TreeNode?):Int{
    if (root == null) return 0
    var left = findFrequentTreeSumRecursive(root.left)
    var right = findFrequentTreeSumRecursive(root.right)
    var sum = left + right + root.`val`
    if (map.containsKey(sum)) {
        val count = map[sum]!! + 1
        if (count == maxCount) {
            frequentAns.add(sum)
        } else if (count > maxCount) {
            maxCount = count
            frequentAns.clear()
            frequentAns.add(sum)
        }
        //不要忘了更新sum出现次数
        map[sum] = count
    } else {
        if (1 == maxCount) {
            frequentAns.add(sum)
        }
        map[sum] = 1
    }
    return sum
}
