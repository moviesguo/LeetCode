package com.moviesguo.algorithm.array

/*
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 *  * 示例 3:
 *
 *  nums1 = [1, 2 , 3 , 4]
 *  nums2 = [5, 6]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 */

// 太难放弃了

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

    //如果一个数组为空，直接计算另一个数组的中位数
    if (nums1.isEmpty()) return calculateMedian(nums2)
    else if(nums2.isEmpty()) return calculateMedian(nums1)
    return 0.0
}

/**
 * 计算偶数的中位数
 */
fun findEvenMedian(nums1:IntArray,nums2: IntArray):Double {
    var mid = (nums1.size + nums2.size) / 2 - 1

    if (mid==0) return ((nums1[0] + nums2[0]) / 2).toDouble()

    var leftIndex = 0
    var rightIndex = nums2.size - 1
    for (i in 0..mid) {
        //如果nums1已经全部并入nums2中,中位数只在nums2中
        if (leftIndex == nums1.size) rightIndex++
        if (rightIndex == nums2.size) leftIndex++
        if (nums1[leftIndex]>nums2[rightIndex]) return 0.0
    }

    return 0.0

}

fun findOddNumberMedian() {

}

/**
 * 计算中位数
 */
fun calculateMedian(nums: IntArray):Double {
    //如果是偶数
    return if(nums.size%2 == 0){
        if (nums.size > 2) ((nums[nums.size / 2] + nums[nums.size / 2 - 1])) / 2.toDouble()
        else ((nums[0] + nums[1]) / 2).toDouble()
    }else {
        nums[nums.size/2].toDouble()
    }
}