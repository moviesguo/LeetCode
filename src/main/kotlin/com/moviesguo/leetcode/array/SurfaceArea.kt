package array

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * 提示：
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 *
 */

fun main() {
    val sub1 = intArrayOf(1,0)
    val sub2 = intArrayOf(0,2)
    val grid = arrayOf(sub1,sub2)
    println(surfaceArea(grid))
}

fun surfaceArea(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0
    var ans = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 0) continue
            ans += (6 * grid[i][j] - (grid[i][j] - 1) * 2)
            if (j > 0) {
                ans -= Math.min(grid[i][j], grid[i][j - 1]) * 2
            }
            if (i > 0) {
                ans -= Math.min(grid[i - 1][j], grid[i][j]) * 2
            }
        }
    }
    return ans
}