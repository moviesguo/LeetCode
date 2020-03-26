package array

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *
 */
fun main() {
    val nums = intArrayOf(1,2,3,1)
    println(findPeakElement(nums))
}
fun findPeakElement(nums: IntArray): Int {
    return findPeakElementHelper(nums, 0, nums.size - 1)
}

/**
 * 二分查找，找到中点之后，我们通过判断mid和mid+1可以确定那边一定存在了峰值
 * 因为数组如果是递增的，那么峰值会在最右边，如果是递减的，那么峰值会在最左边
 * 如果不规则的，那么肯定会有峰值了，继续找就是了
 *
 * mid和mid+1 那个大就去哪边找
 */
fun findPeakElementHelper(nums: IntArray, start: Int, end: Int): Int {
    if (start == end) return start
    val mid = (start + end) / 2
    if (nums[mid] > nums[mid + 1])
        return findPeakElementHelper(nums, start, mid)
    return findPeakElementHelper(nums, mid + 1, end)
}