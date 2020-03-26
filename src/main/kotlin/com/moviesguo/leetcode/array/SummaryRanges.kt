package array

import java.lang.StringBuilder

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 *
 */

fun main() {
    val nums = intArrayOf(0,2,4,5,7)
    println(summaryRanges(nums))
}

fun summaryRanges2(nums: IntArray): List<String> {
    var j = 0
    val ans = ArrayList<String>()
    for (i in nums.indices) {
        if (i + 1 < nums.size && nums[i + 1] == nums[i] + 1) continue
        if (i == j) {
            ans.add(nums[i].toString())
        } else {
            ans.add("${nums[j]}->${nums[i]}")
        }
        j = i + 1
    }
    return ans
}

/**
 * 还是单独处理了0和last的，不大好
 */
fun summaryRanges(nums: IntArray): List<String> {
    if (nums.isEmpty()) return emptyList()
    val sb = StringBuilder()
    val ans = ArrayList<String>()
    var lastIndex = 0

    sb.append(nums[0])
    /**
     * 比较自身和后一个的大小,如果后一个比自身大1,那么就继续找
     * 如果当前等于上一次的起始位置,那么自己是不连续的
     * 如果不等于那么 上一次到自身就是一个区间
     * 将上一次置为下一个数
     */
//    for (i in nums.indices) {
//        if (i + 1 < nums.size && nums[i + 1] == nums[i] + 1) continue
//        if (i == lastIndex) {
//            ans.add(nums[i].toString())
//        } else {
//            ans.add("${nums[lastIndex]}->${nums[i]}")
//        }
//        lastIndex = i + 1
//    }

    for (i in 1 until nums.size) {
        if (nums[i] - 1 == nums[i - 1]) continue
        if (lastIndex != i - 1) {
            sb.append("->${nums[i - 1]}")
        }
        ans.add(sb.toString())
        sb.clear()
        sb.append(nums[i])
        lastIndex = i
    }
    if (lastIndex == nums.size - 1) {
        ans.add(sb.toString())
    }else if (sb.isNotEmpty()) {
        sb.append("->${nums[nums.size - 1]}")
        ans.add(sb.toString())
    }
    return ans
}