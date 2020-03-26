package array

import java.util.*
import kotlin.collections.ArrayList

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 */

fun main() {
    println(0 and 1)
    println(1 and 1)
    println(1 and 2)
    println(0 and 2)
    println(2 and 2)

}


fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) return emptyList()
    val ans = ArrayList<List<Int>>()
    Arrays.sort(nums)
    for (i in 0 until nums.indices.last - 2) {
        //确保i对应的值变了
        if (i > 0 && nums[i] == nums[i - 1]) continue
        for (j in i + 1 until nums.indices.last - 1) {
            //确保j对应的值变了
            if (j > i + 1 && nums[j] == nums[j - 1]) continue
            var next = j + 1
            var end = nums.indices.last
            while (next < end) {
                val sum = nums[i] + nums[j] + nums[next] + nums[end]
                when {
                    sum == target -> {
                        //找到相同的就加进去
                        ans.add(arrayListOf(nums[i], nums[j], nums[next], nums[end]))
                        //将next和end指向的位置变为另一个不同的值
                        while (next < end && nums[next] == nums[next + 1]) next++
                        while (next < end && nums[end] == nums[end - 1]) end--
                        next++
                        end--
                    }
                    sum > target -> end--
                    else -> next++
                }
            }
        }
    }
    return ans
}