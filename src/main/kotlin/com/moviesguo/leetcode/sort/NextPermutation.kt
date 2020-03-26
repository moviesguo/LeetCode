package com.moviesguo.algorithm.sort

/*
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 1,3,2  2,1,3
 *
 * 2,3,1  3,1,2
 *
 */

fun main(){
    var nums = intArrayOf(1)
    nextPermutation(nums)
    println(nums.contentToString())
}

fun nextPermutation(nums: IntArray): Unit {
    if (nums.isEmpty()) return
    var i = nums.size - 2

    while (i >= 0 && nums[i + 1] <= nums[i]) {
        i--
    }
    if (i >= 0) {
        var j = nums.size - 1
        while (j >= 0 && nums[j] <= nums[i]) {
            j--
        }
        swap(nums, i, j)
    }
    reverse(nums, i + 1)

    /**
     * 当时没有想到在找到可以对换的位置之后,在该位置后面的数组,是一个降序数组,直接将替换位置之后的数组反转即可
     * 太蠢了
     */
//    while (i != endIndex) {
//        //找到最小的数
//        if (nums[i] < nums[min]) min = i
//
//        if (!hasNext && nums[i] > nums[i - 1]) {
//            if (nums[i - 1] >= nums[min]) {
//                i = min - 1
//                min = i
//                continue
//            }
//            swap(nums, min, i - 1)
//            hasNext = true
//            endIndex = i - 1
//            i = nums.size - 1
//            min = i
//            println(nums.contentToString())
//            continue
//        }
//        if (hasNext && nums[i] < nums[i - 1] && i - 1 != endIndex) {
//            swap(nums, min, i - 1)
//            i = nums.size - 1
//            min = i
//            println(nums.contentToString())
//            continue
//        }
//        i--
//    }
//    if (!hasNext) nums.reverse()
}

fun reverse(nums: IntArray, start: Int) {
    var i = start
    var j = nums.size - 1
    while (i < j) {
        swap(nums, i, j)
        i++
        j--
    }
}

fun swap(nums: IntArray, i: Int, j: Int) {
    var temp  = nums[j]
    nums[j] = nums[i]
    nums[i] = temp
}