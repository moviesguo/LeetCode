package array

import java.util.*
import kotlin.collections.ArrayList

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */

fun main() {
    val nums = intArrayOf(10,1,2,7,6,1,5)
    println(combinationSum2(nums,8))
}

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    if (candidates.isEmpty()) return emptyList()
    Arrays.sort(candidates)
    combinationHelper(ArrayList(), target, candidates, 0)
    return combinationAns
}

val combinationAns = ArrayList<List<Int>>()

/**
 * 类似CombinationSum,不断地去找target-candidates[i],找到target为0的就加入
 * 因为不能使用同一个数字。所以每向下一层就要从上一层起始位置的下一个开始  所以递归传递的是 i+1 而不是index+1,因为这样可能上一层已经从 index=3变成了index=4
 * ，而你还是从 index = 3的时候 + 1开始，也就是你和你的上一层已经重复了
 * 如果同一层使用了相同的数，也会造成重复，所以 我们先排序，然后在第二次判断与上一次是否相同，相同则跳过
 * 每一层遍历中的每次循环完成后要移除掉自己，这是回溯的重点，回到了一个原来的状态,也就是继续向下找有没有符合这一层条件的
 */
fun combinationHelper(cur: MutableList<Int>, target: Int,candidates: IntArray,index:Int) {
    if (target == 0) {
        combinationAns.add(ArrayList(cur))
        return
    }
    for (i in index until candidates.size) {
        if (target - candidates[i] < 0) return
        if (i > index && candidates[i - 1] == candidates[i]) continue
        cur.add(candidates[i])
        combinationHelper(cur, target - candidates[i], candidates, i + 1)
        cur.removeAt(cur.lastIndex)
    }
}



