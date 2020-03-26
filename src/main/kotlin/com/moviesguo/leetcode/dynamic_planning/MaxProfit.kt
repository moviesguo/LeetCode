package com.moviesguo.algorithm.dynamic_planning

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 */


fun main() {

    var prices = intArrayOf(7, 6,4,3,1)
    println(maxProfit(prices))

}

/**
 * 暴力计算
 */
fun maxProfit(prices: IntArray): Int {

    var maxProfit = 0

    for (i in 0 until prices.size) {
        for (j in i + 1 until prices.size) {
            var profit = prices[j] - prices[i]
            maxProfit = Math.max(maxProfit,if (profit <0) 0 else profit)
        }
    }
    return maxProfit
}

fun helper(prices: IntArray): Int {

    var minPrice = Int.MAX_VALUE
    var maxProfit = 0

    /**
     *  类似交替前进那种,minPrice相当于在某个位置一直停留,之后i继续移动,找到比minPrice更小的数的时候再去移动minPrice指针
     *  10,2,9,1,2,1,3,1
     *  第一次计算出maxProfit 是在2,9 maxProfit = 7
     *  这个时候继续往下走  minPrice变成了1 最小值比之前更小了,但是9这个数值可能在之后就不会再出现
     *  所以后面所有用来计算的值都会比minPrice为2时的情况大,只需要比较计算出来的maxProfit就可以了
     *
     */
    for (i in 0 until prices.size) {
        //如果当前值小于最小值则替换一下子
        if (prices[i] < minPrice) minPrice = prices[i]
        //判断当前值减去最小值是否大于了之前计算出的最大值
        if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice
    }
    return maxProfit

}