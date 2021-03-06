package com.moviesguo.leetcode.array

/**
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 */
fun main() {
    val nums = intArrayOf(1,1,1,2,2,2,3,3)
    println(hasGroupsSizeX(nums))
}

fun hasGroupsSizeX(deck: IntArray): Boolean {
    if (deck.isEmpty()) return false
    val map = HashMap<Int, Int>()
    //把每个数出现的次数统计一下
    deck.forEach {
        if (map.containsKey(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
    }
    //排序并去重出现的次数
    val sorted = map.values.toList().distinct().sorted()
    //如果排序后的结果小于两个就是出现次数相同，只要出现次数>=2就可以
    if (sorted.size < 2) return sorted[0] >= 2
    var divided = sorted[0]
    var divisor = sorted[1]
    //求两个最小的数的最大公约数，然后用这个公约数再去看是否能把其他出现的所有数字都整除了，如果可以说明可以将数组评分成最大公约数的倍数
    //如果这个最大公约数大于等于2，那么就满足条件
    //如果其中有任何一个数不能被这个最大公约数整除，那么就不满足这个条件
    val remainder = gcd(divided, divisor)
    for (i in 2 until sorted.size) {
        if (sorted[i] % remainder != 0) return false
    }

    return remainder >= 2
}

fun gcd(a: Int, b: Int):Int {
    if (b == 0) return a
    return gcd(b, a % b)
}