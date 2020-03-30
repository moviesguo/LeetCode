package com.moviesguo.leetcode.array

/**
 *
 * 414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 */

/**
 * 上来想的是 排序加入到set，然后输出第三个，但是时间复杂度要求不符合
 * 现在的做法是保存3个最大的数，然后不断更新
 */
fun thirdMax(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    var firstMax = nums[0]
    var secondMax = Long.MIN_VALUE
    var thirdMax = Long.MIN_VALUE

    nums.forEach {
        if (it == firstMax || it.toLong() == secondMax || it.toLong() == thirdMax) {
            //如果存在相同的数,不再去排序
        } else {
            when {
                it>firstMax -> {
                    //比第一个还大就都往后搓一下
                    thirdMax = secondMax
                    secondMax = firstMax.toLong()
                    firstMax = it
                }
                it > secondMax -> {
                    //比第二个还大就搓这俩
                    thirdMax = secondMax
                    secondMax = it.toLong()
                }
                it > thirdMax -> {
                    //只比第三个大就第三个
                    thirdMax = it.toLong()
                }
            }
        }

    }
    if (nums.size >= 3 && thirdMax != Long.MIN_VALUE) return thirdMax.toInt()
    else return firstMax
}