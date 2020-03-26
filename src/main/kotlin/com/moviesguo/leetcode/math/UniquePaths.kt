package com.moviesguo.algorithm.math

/*
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 */

fun main() {

    println(uniquePaths(3, 7))

}


/**
 * 计算从 m+n-2步中选m-1步向下走
 * 应该是这样应,已经忘记了原因 甚至忘记了用这个方式,还想着列个方程呢
 *
 */
fun uniquePaths(m: Int, n: Int): Int {

    var N = m + n - 2
    var K = m - 1
    var res: Long = 1
    for (i in 1..K) {
        res = res * (N - K + i) / i
    }
    return res.toInt()
}