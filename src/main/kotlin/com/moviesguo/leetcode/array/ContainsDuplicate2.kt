package array

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 */

fun main() {
    val nums = intArrayOf(1,0,1,1)
    println(containsNearbyDuplicate(nums, 1))
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        if (!map.containsKey(nums[i])) {
            map[nums[i]] = i
        } else {
            if (i - map[nums[i]]!! <= k) return true
            map[nums[i]] = i
        }
    }
    return false
}

fun containsNearbyDuplicate2(nums:IntArray,k:Int):Boolean{
    val set = HashSet<Int>()
    for (i in nums.indices) {
        //如果找到了相同的就返回true
        if (set.contains(nums[i])) return true
        //没有就添加进去
        set.add(nums[i])
        //如果当前已经超过了k元素，那么就删除最老的一个
        if (set.size > k) {
            set.remove(nums[i - k])
        }
    }
    return false
}