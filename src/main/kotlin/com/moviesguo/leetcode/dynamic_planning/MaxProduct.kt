package com.moviesguo.algorithm.dynamic_planning

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 */

fun main() {

    var nums = intArrayOf(2, -3, 0, 4, 5, -3, 7, 8)
    println(maxProduct(nums))
}

/**
 *
 * d[i] = d[i-1] * num[j]
 *
 * 大体上是计算出前一次的最大值再去
 *
 */
fun maxProduct(nums: IntArray): Int {

    var minVal = 1
    var maxVal = 1
    var max = Int.MIN_VALUE

    for (i in 0 until nums.size) {
        if (nums[i] < 0) {
            var temp = maxVal
            maxVal = minVal
            minVal = temp
        }
        maxVal = Math.max(maxVal * nums[i], nums[i])
        minVal = Math.min(minVal * nums[i], nums[i])

        max = Math.max(max, maxVal)
    }

    return max
}