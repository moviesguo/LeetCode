package array

import com.sun.xml.internal.fastinfoset.util.StringArray
import java.lang.StringBuilder
import java.util.*
import kotlin.Comparator

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 */

fun main() {
    val nums = intArrayOf(3, 30, 34, 5, 9)
    println(largestNumber(nums))
}

/**
 * compartor证明
 * https://leetcode-cn.com/problems/largest-number/solution/zui-da-shu-bi-jiao-gui-ze-chuan-di-xing-yi-ji-suan/
 */
fun largestNumber(nums: IntArray): String {
    val array = arrayOfNulls<String>(nums.size)
    for (index in nums.indices) {
        array[index] = nums[index].toString()
    }
    Arrays.sort(array) { o1, o2 ->
        val s1 = o1 + o2
        val s2 = o2 + o1
        s2.compareTo(s1)
    }
    if (array[0].isNullOrEmpty() || array[0]?.equals("0") == true) return "0"
    val sb = StringBuilder()
    array.forEach {
        it.let { sb.append(it) }
    }
    return sb.toString()
}
