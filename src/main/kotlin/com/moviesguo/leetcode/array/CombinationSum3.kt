package array

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */

val combinationSum3Ans = ArrayList<List<Int>>()

fun main() {
    val combinationSum3 = combinationSum3(3, 9)
    println(combinationSum3)
}

fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        combinationSum3Helper(k,n,1,ArrayList())
    return combinationSum3Ans
}

/**
 * 思路和combinationSum2一样
 * 都是回溯，从1开始加入到sub，然后再从后面开始找对应的target-i,
 * 第一层递归 target = 9 1进数组
 * 第二层递归 target = 8 2进数组
 * 第三层递归 target = 6 3进数组
 * 第四层递归 target = 3 4 > target 返回
 * 第三层递归 target = 6 3出数组
 * 第三层递归 target = 6 4进然后重复上面2步
 * 第三层递归 target = 6 6进数组
 * 第四层递归 target = 0 加入到最终回答 记得拷贝
 * 之后就是重复这些
 *
 */
fun combinationSum3Helper(k: Int, target: Int, start: Int, sub: MutableList<Int>) {
    if (target == 0 && k == sub.size) {
        combinationSum3Ans.add(ArrayList(sub))
        return
    }
    for (i in start..9) {
        if (i > target) return
        if (target - i < 0 || i > 9 || k <= sub.size) return
        sub.add(i)
        combinationSum3Helper(k, target - i, i + 1, sub)
        sub.removeAt(sub.size - 1)
    }
}