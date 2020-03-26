package com.moviesguo.algorithm.dynamic_planning

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,8,1,14,1,4]
 *
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 */

fun main() {

    var nums = intArrayOf(2,1,1,144,1,4)
    println(rob(nums))
}

/**
 * 动态规划
 *
 * d[i] 表示偷窃到i家能得到的最高金额
 *  d[i-2] + nums[i] 是表示第i家不偷的情况,d[i-1]是表示第i家偷的情况
 *  如果第i-1家不偷的话那么其实 d[i-2]就是 i-1不偷的总金额所以其实已经包括了搁一家一偷的情况
 * d[i] = Math.max(d[i-2]+nums[i],d[i-1]])
 *
 *
 */
fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]
    var d = IntArray(nums.size + 1)
    d[0] = nums[0]
    d[1] = Math.max(nums[0], nums[1])
    println("0 : ${d[0]}")
    println("1 : ${d[1]}")
    for (i in 2 until nums.size) {
        d[i] = Math.max(d[i - 2] + nums[i], d[i - 1])
        println("$i : ${d[i]}")
    }
    return d[nums.size - 1]
}
