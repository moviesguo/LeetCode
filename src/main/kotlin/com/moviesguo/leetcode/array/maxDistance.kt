package com.moviesguo.leetcode.array

import java.util.*

/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。
 * 其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * 输入：[[1,0,1],
 *       [0,0,0],
 *        [1,0,1]]
 *  输出：2
 *  解释：
 *  海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 * 输入：[[1,0,0],
 *       [0,0,0],
 *       [0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 *
 */



fun main() {

    val grid = arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, 0, 0), intArrayOf(1, 0, 1))
    println(maxDistance(grid))

}

/**
 * 因为我们只要先把所有的陆地都入队，然后从各个陆地同时开始一层一层的向海洋扩散，那么最后扩散到的海洋就是最远的海洋！
 * 并且这个海洋肯定是被离他最近的陆地给扩散到的！
 * 你可以想象成你从每个陆地上派了很多支船去踏上伟大航道，
 * 踏遍所有的海洋。每当船到了新的海洋，就会分裂成4条新的船，
 * 向新的未知海洋前进（访问过的海洋就不去了）。如果船到达了某个未访问过的海洋
 * ，那他们是第一个到这片海洋的。很明显，这么多船最后访问到的海洋，肯定是离陆地最远的海洋。
 *
 */
fun maxDistance(grid: Array<IntArray>): Int {
    var hasOcean = false
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    //使用队列保证每一个陆地都是依次扩散一层
    val queue = LinkedList<IntArray>()
    val m = grid.size
    val n = grid[0].size
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 1){
                queue.offer(intArrayOf(i, j))
            }
        }
    }
    var point :IntArray? = null
    while (queue.isNotEmpty()) {
        point = queue.poll()
        val x = point[0]
        val y = point[1]
        for (i in 0 until 4) {
            val newX = x + dx[i]
            val newY = y + dy[i]
            if (newX >= m || newX < 0 || newY >= n || newY < 0 || grid[newX][newY] != 0) continue
            //这里赋值则保证了最先到达该海洋的最小值，也就是离这个海洋最远的陆地
            grid[newX][newY] = grid[x][y] + 1
            queue.offer(intArrayOf(newX, newY))
            hasOcean = true
        }
    }
    if (point == null || !hasOcean) return -1
    return grid[point[0]][point[1]] - 1
}


/**
 * 到达陆地可能能是从左，上，右，下，四个方向来的
 * 我们第一次要把dp中
 */
//fun maxDistance(grid: Array<IntArray>): Int {
//    if (grid.isEmpty()) return -1
//    val dp = Array<IntArray>(grid.size) { IntArray(grid.size) }
//
//    for (i in dp.indices) {
//        for (j in dp[0].indices) {
//            dp[i][j] = if (grid[i][j] == 1) 0 else Int.MAX_VALUE
//        }
//    }
//
//    //从上或者左边到陆地的距离,然后保存最小的
//    for (i in dp.indices) {
//        for (j in dp[0].indices) {
//            if (grid[i][j] != 0) continue
//            if (i - 1 >= 0 ) dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j])
//            if (j - 1 >= 0) dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j])
//        }
//    }
//
//    val size = dp.size - 1
//    //从右边或者下边边到陆地的距离,然后保存最小的
//    for (i in size downTo 0) {
//        for (j in size downTo 0) {
//            if (grid[i][j] != 0) continue
//            if (i + 1 < dp.size ) dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j])
//            if (j + 1 < dp.size) dp[i][j] = Math.min(dp[i][j + 1] + 1, dp[i][j])
//        }
//    }
//
//    var ans = -1
//    //遍历最后的结果，取最大的
//    for (i in 0 .. size) {
//        for (j in 0 .. size) {
//            if (dp[i][j] != 0) {
//                ans = Math.max(ans, dp[i][j]);
//            }
//        }
//    }
//    if (ans == Int.MAX_VALUE) return -1
//    return ans
//}