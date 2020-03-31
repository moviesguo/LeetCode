package com.moviesguo.leetcode.sort

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 */

fun main() {
    val nums = intArrayOf(1,2,3,4,5,6,0,7,8,9,10,0)
    val sortArray = sortArray(nums)
    println(sortArray.contentToString())
}

fun sortArray(nums: IntArray): IntArray {
    quickSort(nums, 0, nums.size - 1)
    return nums
}

/**
 * 快速排序
 */
fun quickSort(nums: IntArray, start: Int, end: Int) {
    if (start >= end) return
    var left = start
    var right = end
    val temp = nums[left]
    while (left < right) {

        while (temp <= nums[right] && left < right) {
            right--
        }
        if (left < right) {
            nums[left++] = nums[right]
        }

        while (temp >= nums[left] && left < right) {
            left++
        }

        if (left < right) {
            nums[right--] = nums[left]
        }
    }
    nums[left] = temp
    quickSort(nums, start, left - 1)
    quickSort(nums, left + 1, end)

}

fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}