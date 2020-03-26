package com.moviesguo.algorithm.array


/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */

fun main() {
    var a = intArrayOf(2,2,1,1,1,2,2)
    println(majorityElement(a))
}

fun majorityElement(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    var majorElement = nums[0]
    var map = HashMap<Int, Int>()
    map[nums[0]] = 1

    for (i in 1 until nums.size) {
        var count = map[nums[i]]
        if (count == null) map[nums[i]] = 1
        else map[nums[i]] = count + 1
        var majorCount = map[majorElement] ?: 0
        if (map[nums[i]]!! > majorCount) {
            majorElement = nums[i]
        }
    }
    return majorElement
}