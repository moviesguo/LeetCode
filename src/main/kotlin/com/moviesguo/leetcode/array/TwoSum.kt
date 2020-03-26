package array

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 */

/**
 * 时间复杂度 O(NlogN)
 */
fun twoSum(numbers: IntArray, target: Int): IntArray {
    for (i in numbers.indices) {
        val other = twoSumHelper(numbers, target - numbers[i], i + 1, numbers.size - 1)
        if (other != -1) return intArrayOf(i, other)
    }
    return intArrayOf()
}

/**
 * 双指针 O(n)时间复杂度
 */
fun twoSumTwoIndex(nums: IntArray, target: Int): IntArray {
    var left = 0
    var right = nums.size - 1
    while (left != right) {
        val res = nums[left] + nums[right]
        if (res == target) return intArrayOf(left + 1, right + 1)
        if (res > target) right--
        else left ++
    }
    return intArrayOf()
}

/**
 * 二分查找另一个值  O(logN)
 */
fun twoSumHelper(nums: IntArray, target: Int, start: Int, end: Int):Int {
    if (start > end) return -1
    val mid = start + (end - start) / 2
    if (nums[mid] == target) return mid
    return if (nums[mid] < target) twoSumHelper(nums, target, mid + 1, end)
    else twoSumHelper(nums, target, start, mid - 1)
}