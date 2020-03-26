package array

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */

/**
 * 二分法
 */

fun main() {
    val nums = intArrayOf(1, 3, 4, 2, 2)
    findDuplicate(nums)
}

/**
 * 以 [1, 2, 2, 3, 4, 5, 6, 7] 为例，一共 8 个数，n + 1 = 8，n = 7，根据题目意思，每个数都在 1 和 7 之间。
 *
 * 例如：区间 [1, 7] 的中位数是 4，遍历整个数组，统计小于等于 4 的整数的个数，至多应该为 4 个。换句话说，整个数组里小于等于 4 的整数的个数如果严格大于 4 个
 * ，就说明重复的数存在于区间 [1, 4]，它的反面是：重复的数存在于区间 [5, 7]。
 * 实际上 left和right就是在找重复的数所在的区间，然后不断地缩小他
 */
fun findDuplicate(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val mid = (left + right) / 2
        var count = 0
        for (num in nums) {
            if (num <= mid) count++
        }
        if (count <= mid) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}