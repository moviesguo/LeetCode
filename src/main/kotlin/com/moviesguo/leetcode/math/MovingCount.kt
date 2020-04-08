package com.moviesguo.leetcode.math

/**
 *
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */

fun main() {

    println(movingCount(4, 6, 15))

}

fun foo(x: Int, y: Int, m: Int, n: Int, k: Int): Int {
    if (x < 0 || x >= m || y < 0 || y <= n) return 0
    if (getSum(x) + getSum(y) > k) return 0
    val down = foo(x + 1, y, m, n, k)
    val right = foo(x, y + 1, m, n, k)
    return down + right
}

fun movingCount(m: Int, n: Int, k: Int): Int {
    var ans = 0
    val dp = Array(m) { IntArray(n) { 0 } }
    dp[0][0] = 1
    for (i in 0 until m) {
        for (j in 0 until n) {
            //从0,0开始往右边和下边找就可以了
            if ((i == 0 && j == 0) || getSum(i) + getSum(j) > k) continue
            if (i - 1 >= 0) dp[i][j] = dp[i][j] or dp[i - 1][j]
            if (j - 1 >= 0) dp[i][j] = dp[i][j] or dp[i][j - 1]
            ans += dp[i][j]
        }
    }
    return ans
}

fun getSum(num: Int):Int {
    var s = num
    var ans = 0
    while (s != 0) {
        ans += s % 10
        s /= 10
    }
    return  ans
}