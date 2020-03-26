package array

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */

fun main() {

    val a = listOf(2)
    val b = listOf(3,4)
    val c = listOf(6,5,7)
    val d = listOf(4, 1, 8, 3)
    val triangle = listOf(a,b)
    val minimumTotal = minimumTotal(triangle)
    println(minimumTotal)
}

/**
 * 动态规划  dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j]
 *          当前路径的最小值为上一层的左侧和上一个的最小值加上当前的值
 */
fun minimumTotal(triangle: List<List<Int>>): Int {
    if (triangle.isEmpty() || triangle[0].isEmpty()) return 0
    val row = triangle.size
    if (row == 1) return triangle[0][0]
    var pre = IntArray(triangle[row - 1].size + 2) { Int.MAX_VALUE }
    pre[1] = triangle[0][0]
    var ans = Int.MAX_VALUE
    var cur = IntArray(triangle[row - 1].size + 2){ Int.MAX_VALUE }
    for (i in 1 until row - 1) {
        val size = triangle[i].size
        for (j in 1..size) {
            //这里优化的不完全，可以只使用pre,next两个变量来存储 pre[j-1]和pre[j]
            //pre = 0 ,next = null
            // next = pre[j]
            // cur[j] = Math.min(pre,next) + triangle[i][j-1]
            //pre = next
            cur[j] = pre[j - 1].coerceAtMost(pre[j]) + triangle[i][j - 1]
        }
        pre = cur.copyOf()
    }
    val size = triangle[row - 1].size
    for (i in 1..size) {
        ans = Math.min(pre[i - 1].coerceAtMost(pre[i]) + triangle[row - 1][i - 1], ans)
    }
    return ans
}

/**
 * 同样是动态规划 这次自底向下 dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
 *                           当前的路径一定是下一层的下一个或右下一个的最小值加上当前的值
 */
fun minimumTotal2(triangle: List<List<Int>>){
    //就不做空间的优化了
    val dp = Array<IntArray>(triangle.size + 1){IntArray(triangle.size + 1){ 0} }
    for (i in (triangle.size - 1) downTo 0) {
        for (j in triangle[i].indices) {
            dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
        }
    }
//    return dp[0][0]
}