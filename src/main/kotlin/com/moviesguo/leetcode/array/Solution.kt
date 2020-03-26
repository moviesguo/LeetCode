package array

import java.util.*
fun main() {
    val s = Solution()
    val nums = intArrayOf(10,1,2,7,6,1,5)
    println(s.combinationSum2(nums, 8))
}
class Solution {



    /**
     * @param candidates 候选数组
     * @param len
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param residue    表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res
     */
    private fun dfs(
        candidates: IntArray,
        len: Int,
        begin: Int,
        residue: Int,
        path: Deque<Int>,
        res: MutableList<List<Int>>
    ) {
        if (residue == 0) {
            res.add(java.util.ArrayList(path))
            return
        }
        for (i in begin until len) { // 大剪枝
            if (residue - candidates[i] < 0) {
                break
            }
            // 小剪枝
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue
            }
            path.addLast(candidates[i])
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, residue - candidates[i], path, res)
            path.removeLast()
        }
    }

    fun combinationSum2(
            candidates: IntArray,
            target: Int
    ): List<List<Int>> {
        val len = candidates.size
        val res: MutableList<List<Int>> =
        java.util.ArrayList()
        if (len == 0) {
            return res
        }
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates)
        val path: Deque<Int> = ArrayDeque(len)
        dfs(candidates, len, 0, target, path, res)
        return res
    }
}
