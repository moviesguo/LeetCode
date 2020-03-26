package array

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.List
import kotlin.collections.emptyList
import kotlin.collections.toList


/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 */
fun main() {
    println(generate(5))
}

/**
 * 动态规划 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
 */
fun generate(numRows: Int): List<List<Int>> {
    if (numRows == 0) return emptyList()
    val ans = ArrayList<List<Int>>()
    val first = ArrayList<Int>()
    first.add(1)
    ans.add(first)
    if (numRows == 1) return ans
    val second = ArrayList<Int>()
    second.add(1)
    second.add(1)
    ans.add(second)
    for (i in 2 until numRows) {
        val sub = IntArray(i + 1) { 1 }
        sub[0] = 1
        sub[i] = 1
        for (j in 1 until i) {
            sub[j] = ans[i - 1][j - 1] + ans[i - 1][j]
        }
        ans.add(sub.toList())
    }
    return ans
}

/**
 * 杨辉三角公式
 */
fun getRow(rowIndex: Int): List<Int> {
    val dp = arrayOfNulls<Int>(rowIndex + 1)
    Arrays.fill(dp, 1)
    for (i in 2 until dp.size) {
        for (j in i - 1 downTo 1) dp[j] = dp[j]!! + dp[j - 1]!!
    }
    return Arrays.asList<Int>(*dp)
}