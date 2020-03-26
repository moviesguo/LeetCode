package array

import java.util.*

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1], k = 2, t = 3
 * 输出: false
 *
 */
fun main() {
    val nums = intArrayOf(2147483647,-2147483647)
    println(containsNearbyAlmostDuplicate(nums, 1, 2147483647))
}
fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
    for (i in nums.indices) {
        for (j in 0 until i) {
            if (i - j > k) continue
            if (Math.abs((nums[i].toLong() - nums[j].toLong())) <= t) return true
        }
    }
    return false
}

fun containsNearbyAlmostDuplicate2(nums: IntArray, k: Int, t: Int):Boolean {
    //平衡二叉树,有序的
    val set = TreeSet<Int>()
    for (i in nums.indices) {
        //查找树中比nums[i]大的最小的数字
        val ceiling = set.ceiling(nums[i])
        ceiling?.apply {
            //如果比比自己大的最小的数字 - nums[i]都大于t那么其他数字也不符合条件
            if (this - nums[i] <= t) return true
        }
        //查找树中比nums[i]小的最大的数
        val floor = set.floor(nums[i])
        floor?.apply {
            //如果比nums[i]-比自己小的最大的数字都大于t那么其他数字也不符合条件
            if (nums[i] - this <= t) return true
        }
        set.add(nums[i])
        if (set.size > k) {
            set.remove(i - k)
        }
    }
    return false
}