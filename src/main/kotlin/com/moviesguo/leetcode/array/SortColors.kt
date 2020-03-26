package com.moviesguo.algorithm.array

/*
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 */

fun main() {

    var nums = intArrayOf(1,2,0)
    sortColors2(nums)
    println(nums.contentToString())
}

/**
 *
 * 计数排序 初始化一个数组temps,temps的索引就是nums中的数值 temps[index]就是nums中存在对应index的数量
 *
 */
fun sortColors(nums: IntArray): Unit {
    var temps = IntArray(3)
    nums.forEach { temps[it]++ }
    var index = 0
    for (i in 0..2) {
        repeat(temps[i]){
            nums[index] = i
            index++
        }
    }
}

/**
 * 荷兰国旗问题 定义3个指针,left/right分别为0,和1的位置,current为当前位置指针
 * 找到0,与left交换位置 找到2与right交换位置
 */
fun sortColors2(nums: IntArray) {

    var leftIndex = 0
    var rightIndex = nums.size - 1
    var currentIndex = 0
    while (currentIndex <= rightIndex) {

        println("left : $leftIndex right : $rightIndex curr : $currentIndex")

        when(nums[currentIndex]) {
            0 -> {
                com.moviesguo.algorithm.sort.swap(nums, leftIndex, currentIndex)
                leftIndex++
                currentIndex++
            }
            2 -> {
                com.moviesguo.algorithm.sort.swap(nums, rightIndex, currentIndex)
                rightIndex--
            }
            else -> currentIndex++
        }
    }

}
