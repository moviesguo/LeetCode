package sort

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */

fun main() {
    val nums1 = intArrayOf(1, 2, 2, 1)
    val nums2 = intArrayOf(1,1)
    intersection(nums1, nums2)
}

fun intersectionSet(nums1: IntArray, nums2: IntArray) {
    val set1 = HashSet<Int>()
    for (i in nums1) {
        set1.add(i)
    }
    val set2 = HashSet<Int>()
    for (i in nums2) {
        set2.add(i)
    }
    val ans = ArrayList<Int>()
    //判断哪个短用哪个
    if (set2.size < set1.size) {
        for (i in set2) {
            if (set1.contains(i)) ans.add(i)
        }
    }

}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    nums1.sort()
    nums2.sort()
    var i = 0
    var j = 0
    val ans = ArrayList<Int>()
    while (i < nums1.size && j < nums2.size) {

        when {
            nums1[i] == nums2[j] -> {
                ans.add(nums1[i])
                i++
                j++
            }
            nums1[i] < nums2[j] -> {
                i++
            }
            nums1[i] > nums2[j] -> {
                j++
            }
        }

    }
    return ans.toIntArray()
}