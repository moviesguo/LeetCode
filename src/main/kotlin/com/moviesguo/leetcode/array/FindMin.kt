package array

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 */
fun main() {
    val nums = intArrayOf(3,1,2)
    println(findMin(nums))
}
fun findMin(nums: IntArray): Int {
    val size = nums.size
    if (size < 2) return nums[0]
    if (nums[0] < nums[size - 1]) return nums[0]
    val mid = finMinHelper(nums, 0, size - 1)
    return nums[mid]
}

/**
 * 二分去找比最左边小的数，然后看他自己和前一位谁大，如果前一位大，那么当前的点就是旋转点
 * 如果自己大，那么还需要向前面那段去找
 */
fun finMinHelper(nums: IntArray, start: Int, end: Int): Int {
    val mid = start + (end - start) / 2
    return if (nums[mid] < nums[0]) {
        if (nums[mid - 1] > nums[mid]) {
            mid
        } else {
            finMinHelper(nums, start, mid - 1)
        }
    } else {
        finMinHelper(nums, mid + 1, end)
    }
}