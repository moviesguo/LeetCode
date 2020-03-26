package array

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 */

fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    println(productExceptSelf(nums).contentToString())
}

fun productExceptSelf(nums: IntArray): IntArray {
    val output = IntArray(nums.size)
    output[0] = 1
    val l = IntArray(nums.size)
    for (i in 1 until nums.size) {
        //计算出i左边的数字乘积
        l[i] = l[i - 1] * nums[i - 1]
    }
    val r = intArrayOf(nums.size)
    r[nums.size - 1] = 1
    for (i in nums.size - 2 downTo 0) {
        //计算出i右边数字的乘积
        r[i] = r[i + 1] * nums[i]
    }

    for (i in nums.indices) {
        //当前的数字成绩=左边的乘积*右边的乘积
        output[i] = l[i] * r[i]
    }

    for (i in 1 until nums.size) {
        output[i] = output[i - 1] * nums[i - 1]
    }
    println(output.contentToString())
    var R = 1
    for (i in nums.size - 1 downTo 0) {
        //同上，只不是使用R代替了l数组
        output[i] = output[i] * R
        R *= nums[i]
    }
    return output
}
