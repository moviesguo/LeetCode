package array

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
fun missingNumber(nums: IntArray): Int {
    val size = nums.size
    var total = size * (size + 1) / 2
    nums.forEach {
        total -= it
    }
    return total
}

/**
 * 按位异或，
 * 异或  0 ^ 1 = 1  1 ^ 1 = 0  0 ^ 0 = 0
 * 所以都异或完了之后剩下的值一定是没有的，所以异或的范围是0-n
 */
fun missingNumberXOR(nums:IntArray): Int {
    val size = nums.size
    var ans = 0
    for (i in 0 until size) {
        ans.xor(nums[i])
    }
    return ans.xor(size)

}