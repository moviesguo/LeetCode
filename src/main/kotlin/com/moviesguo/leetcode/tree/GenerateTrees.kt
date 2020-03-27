package com.moviesguo.leetcode.tree

import com.moviesguo.algorithm.tree.TreeNode

/**
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *   1         3   3      2      1
 *   \       /    /      / \      \
 *   3      2    1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 *
 */

fun main() {
    val generateTrees = generateTrees(3)
    println(generateTrees.size.toString())
}

fun generateTrees(n: Int): List<TreeNode?> {
    if (n <=0) return ArrayList()
    return helper(1,n)
}

/**
 * 动态规划版本
 */
fun dp(n: Int):List<TreeNode?> {

    val dp = Array<MutableList<TreeNode?>>(n+1){ ArrayList()}
    dp[0] = ArrayList() //0也需要加上，不然1会报空指针
    dp[0].add(null)
    for (i in 1..n) {
        val left = i - 1    //左子树的节点数
        val right = n - i   //右子树的节点数
        /**
         * 假设n为5，root是3，那么左边有2个节点，所以去dp[2]里面找，右边也有两个节点4,5。所以还去dp[2]里面找。
         * 因为只有dp[2]里面都是2个节点的数。但是dp[2]中的数只有1和2，我们要的是4,5。
         * 我们不妨将1,2加上root，你会发现正好是4,5。
         * 所以得到结论，左子树的值直接找前面节点数一样的dp索引，右子树的值也找前面一样的dp索引,
         * 但是你需要加上root才能保证val是你需要的，所以右子树要重新创建，不然会破坏前面的树。
         */
        dp[left].forEach { left->
            dp[right].forEach { right->
                val root = TreeNode(i)
                root.left = left
                root.right = clone(i, right)
                dp[i].add(root)
            }
        }
    }
    return dp[n]
}

fun clone(value: Int, root: TreeNode?): TreeNode? {
    if (root == null) return null
    val node = TreeNode(value + root.`val`)
    node.left = clone(value,root.left)
    node.right = clone(value, root.right)
    return node
}

fun helper(start: Int, end: Int): List<TreeNode?> {
    val trees = ArrayList<TreeNode?>()
    if (start>end){
        trees.add(null)
        return trees
    }
    if (start == end) {
        val root = TreeNode(start)
        trees.add(root)
        return trees
    }
    for (i in start..end) {
        val left = helper(start, i - 1)
        val right = helper(i + 1, end)
        for (leftNode in left) {
            for (rightNode in right) {
                val root = TreeNode(i)
                root.left = leftNode
                root.right = rightNode
                trees.add(root)
            }
        }
    }

    return trees
}