package com.moviesguo.algorithm.array


/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */

fun main() {
    var a = intArrayOf(2,2,1,1,1,2,2)
    println(majorityElement(a))
}

/**
 * 使用map的方式 时间复杂度O(1) 空间复杂度 O(n+k)
 */
fun majorityElement(nums: IntArray): List<Int> {
    val map = HashMap<Int, Int>()
    val count = nums.size / 3
    for (i in nums.indices) {
        if (map.containsKey(nums[i])) {
            map[nums[i]] = (map[nums[i]]!! + 1)
        } else {
            map[nums[i]] = 1
        }
    }
    val ans = ArrayList<Int>()
    map.forEach {
        if (it.value > count) ans.add(it.key)
    }
    return ans
}

/**
 * 摩尔投票法
 */
fun majorityElementHelper(nums:IntArray):List<Int>{
    if (nums.isEmpty()) return emptyList()

    var candidateA = nums[0]
    var candidateB = nums[0]
    var countA = 0
    var countB = 0
    //选中两个候选人，如果遇见相同的+1,不相同-1
    //如果count为0，那么切换候选人
    //因为出现次数大于n/3的最多只有两个
    for (i in nums.indices) {
        if (candidateA == nums[i]) {
            countA++
            continue
        }
        if (candidateB == nums[i]){
            countB++
            continue
        }

        if (countA == 0) {
            candidateA = nums[i]
            countA++
            continue
        }

        if (countB == 0) {
            candidateB = nums[i]
            countB++
            continue
        }
        countA--
        countB--
    }
    countA = 0
    countB = 0
    nums.forEach {
        if (it == candidateA) countA++
        else if (it == candidateB) countB++
    }
    val ans = ArrayList<Int>()
    if (countA>nums.size/3) ans.add(candidateA)
    if (countB>nums.size/3) ans.add(candidateB)
    return ans
}