package com.moviesguo.algorithm.tree


/**
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *       3
 *     /  \
 *    9  20
 *      /  \
 *     15  7
 * 返回其层次遍历结果：
 *
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 *    1
 *  2   3
 * 4     5
 *
 */

fun main() {

    val root = TrieNode()
    val left = TrieNode()
    val right = TrieNode()
    root.`val` =1
    left.`val` =2
    right.`val` = 3
    root.left = left
    root.right = right

    var leftLeft = TrieNode()
    leftLeft.`val` = 4

    left.left = leftLeft

    var rightLeft = TrieNode()
    var rightRight = TrieNode()
    rightLeft.`val` = 15
    rightRight.`val` = 5
//    right.left = rightLeft
    right.right = rightRight

    var levelOrder = levelOrder(root)
    levelOrder.forEach(::print)

}

fun levelOrder(root: TrieNode?): List<List<Int>> {
    val res = ArrayList<MutableList<Int>>()
    helper(root, res, 0)
    return res
}

/**
 * 加入层级的参数后,直接加入到对应层级的子集中
 */
fun helper(root: TrieNode?, res:MutableList<MutableList<Int>>, level: Int) {
    if (root == null) return
    if (res.size>level) res[level].add(root.`val`)
    else{
        val sub = ArrayList<Int>()
        sub.add(root.`val`)
        res.add(sub)
    }
    helper(root.left, res, level + 1)
    helper(root.right, res, level + 1)
}