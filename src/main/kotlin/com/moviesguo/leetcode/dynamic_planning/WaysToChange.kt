package com.moviesguo.leetcode.dynamic_planning


/**
 * 面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= n (总金额) <= 1000000
 */

fun main() {
    val wa = WaysToChange()
    println(wa.waysToChange(10))
}

class WaysToChange {

    // 记得看题解https://leetcode-cn.com/problems/coin-lcci/solution/
    fun waysToChange(n: Int): Int {
        val numArray = IntArray(n+1){1}
        val coinArray = intArrayOf(1,5,10,25)

        (1 until 4)
            .forEach { coinIndex ->
                (1 until n + 1)
                    .filter { it >= coinArray[coinIndex] }
                    .forEach {
                        numArray[it] = (numArray[it] + numArray[it - coinArray[coinIndex]]) % 1000000007
                    }
            }

        return numArray[n]
    }
}