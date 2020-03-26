package array


/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */

fun main() {
    val nums = intArrayOf(2,1)
    moveZeroes(nums)
    println(nums.contentToString())
}

/**
 * 双指针，找到不是0的然后交换位置，如果非零元素两个指针同时前进
 * 如果遇到0只前进快指针
 */
fun moveZeroes(nums: IntArray): Unit {
    var slow = 0
    for (index in nums.indices) {
        if (nums[index] != 0 ) {
            val temp = nums[slow]
            nums[slow] = nums[index]
            nums[index] = temp
            slow++
        }
    }
}