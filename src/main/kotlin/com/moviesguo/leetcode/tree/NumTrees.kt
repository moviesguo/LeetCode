package com.moviesguo.algorithm.tree

/**
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 */

//GG思密达,完全就是数学的东西啊,思路有了但是不会推公式,难受
fun main() {
    var numTrees = numTrees(7)
    println("result : $numTrees")
}

/**
 *
 * G(n) 为长度为n的序列的不同二叉搜索树数量
 * F(i,n) 为当i为根节点时,长度为n的序列的不同二叉搜索树数量
 * 所以 G(n) += for(i in 1..n)F(i,n)
 * 以F(3,7)举例,当3是根节点时,F(i,n) = G[i-1]*G[n-i] 即 G[2]*G[4]
 * 所以 G(n) += for(i in 1..n)G[i-1]*G[n-i]
 *
 */
fun numTrees(n: Int): Int {

    var G = IntArray(n + 1)
    G[0] = 1
    G[1] = 1

    for (i in 2..n) {
        for (j in 1..i) {
            //这里是计算F(i,n)的,以j为根节点,i为长度 最后算的是 G[i]的值,也就是i长度下,不同二叉搜索树的数量
            println("${G[i]} = ${G[i]} + ${G[j - 1]} * ${G[i - j]}")
            println("G[$i] = G[$i] + G[${j - 1}] * G[${i - j}]")
            G[i] += G[j - 1] * G[i - j]     //j是作为根节点的数字
        }
    }

    return G[n]
}