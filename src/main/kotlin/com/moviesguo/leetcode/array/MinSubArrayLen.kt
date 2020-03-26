package array

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 */
fun minSubArrayLen(s: Int, nums: IntArray): Int {
    //初始化两个指针，都指向0，然后一个动一个不动
    //sum不断地增大，直到找到sum>=s的时候停下，然后将另一个指针向前移动，同时不断地减小sum的值
    //然后再不断地更新最小值
    //https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/209shuang-zhi-zhen-hua-dong-chuang-kou-by-fo-qian-/
    var i = 0
    var ans = Int.MAX_VALUE
    var sum = 0
    for (j in nums.indices) {
        sum += nums[j]
        while (sum >= s) {
            ans = Math.min(ans, j - i + 1)
            sum -= nums[i++]
        }
    }
    if (ans == Int.MAX_VALUE) return 0
    return ans
}

fun minSubArrayLen2(s: Int, nums: IntArray) {
    val sum = IntArray(nums.size)
    //记录前i个相加的和
    sum[0] = 0
    var ans = Int.MAX_VALUE

    for (i in 1 until nums.size)
        //把和都计算出来保存
        sum[i] = sum[i - 1] + nums[i]

    for (i in 1 until nums.size) {
        //保存当前所有值相加的和
        for (j in i until nums.size) {
            // j - i 之间相加的和 = j位置的和-i位置的和 + nums[j]
            val sum = sum[j] - sum[i] + nums[j]
            if (sum >= s) ans = Math.min(ans, j - i + 1)
            break
        }
    }

}
