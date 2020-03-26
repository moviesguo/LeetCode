package array

import java.util.*
import kotlin.math.abs

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
fun threeSumClosest(nums: IntArray, target: Int): Int {
    //先排序
    Arrays.sort(nums)
    //由于是3个数，先选前面两个小的和最后一个最大的，然后让最后一个不断地去往前找，之后再选两个比之前大一些的，还是从后往前找，不断循环下去
    var ans = nums[0] + nums[1] + nums[nums.size - 1]
    //举例  nums[0] + nums[1] + nums[last]  一直找到 nums[0] + nums[1] + nums[2]
    //然后第二次循环 nums[1] + nums[2] + nums[last] 一直找到 nums[1] + nums[2] + nums[3]
    //直到 target == sum或者循环完成
    for (i in nums.indices) {
        var start = i + 1
        var end = nums.indices.last
        while (start < end) {
            val sum = nums[i] + nums[start] + nums[end]
            if (abs(target - sum) < abs(target - ans)) {
                ans = sum
            }
            when {
                sum > target -> end--
                sum < target -> start++
                else -> return ans
            }
        }
    }
    return ans
}