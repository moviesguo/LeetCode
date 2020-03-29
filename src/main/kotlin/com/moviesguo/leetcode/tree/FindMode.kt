package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *   2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 */
fun findMode(root: TreeNode?): IntArray {
    if (root == null) return intArrayOf()
    val list = ArrayList<Int>()
    val ans = ArrayList<Int>()
    recursive(root, list)
    var curNum = 1
    var maxNum = 1
    ans.add(list[0])
    for (i in 1 until list.size) {
        if (list[i] == list[i - 1]) {
            curNum++
        } else {
            curNum = 1
        }
        if (maxNum == curNum) {
            ans.add(list[i])
        } else if (maxNum < curNum){
            ans.clear()
            ans.add(list[i])
            maxNum = curNum
        }
    }
    return ans.toIntArray()
}

fun recursive(node: TreeNode?, list: ArrayList<Int>) {
    if(node == null) return
    recursive(node.left, list)
    list.add(node.`val`)
    recursive(node.right, list)
}

fun main() {
    val root = TreeNode(1)
    val node1 = TreeNode(1)
    root.left = node1
    findModeRecursive(root)
}

val findModeAns = ArrayList<Int>()
var curNum = 0
var maxNum = 0
var findModePre :TreeNode? = null
/**
 * 中序遍历二叉树
 * pre指向前一个节点，如果前一个节点和自己相同curCount+1如果不同curCount置为1
 * 每次都会去比较curCount和maxCount,如果大了就清空list然后添加当前值,等于就直接添加到list
 * 小于就省略
 */
fun findModeRecursive(node: TreeNode?) {
    if (node == null) return
    findModeRecursive(node.left)
    if (findModePre?.`val` == node.`val`) {
        curNum++
    } else {
        curNum = 1
    }
    if (curNum == maxNum) {
        findModeAns.add(node.`val`)
    }else if (curNum > maxNum) {
        findModeAns.clear()
        findModeAns.add(node.`val`)
        maxNum = curNum
    }
    findModePre = node
    findModeRecursive(node.right)
}