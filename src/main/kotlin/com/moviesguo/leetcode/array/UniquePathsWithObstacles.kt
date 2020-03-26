package array

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *  网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 *  说明：m 和 n 的值均不超过 100。
 *
 *  示例 1:
 *
 *  输入:
 *  [
 *    [0,0,0],
 *    [0,1,0],
 *    [0,0,0]
 *  ]
 *  输出: 2
 *  解释:
 *  3x3 网格的正中间有一个障碍物。
 *  从左上角到右下角一共有 2 条不同的路径：
 *  1. 向右 -> 向右 -> 向下 -> 向下
 *  2. 向下 -> 向下 -> 向右 -> 向右
 *
 */
fun main() {
    val a = intArrayOf(0, 0, 0)
    val b = intArrayOf(0, 1, 0)
    val c = intArrayOf(0, 0, 0)
    val array = arrayOf(a, b, c)
    println(uniquePathsWithObstacles(array))
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    if(obstacleGrid.isEmpty()) return 0
    if (obstacleGrid[0][0] == 1) return 0
    val dp = Array<IntArray>(obstacleGrid.size){ IntArray(obstacleGrid[0].size) { 0 } }
    val ver = obstacleGrid.size
    val hor = obstacleGrid[0].size
    dp[0][0] = 1
    //这个就相当于方程有多个解，在i=0,j=0的时候为1，然后i≠0，j=0的时候就是 没有堵住的时候 dp[i][0] = dp[i - 1][0] 挡住了就是0,剩下的同理
    //只是第一行和第一列需要先确定在能继续往下规划
    //前提的条件都需要确定，不然没办法解决子问题
    //先计算出来 所有d[i][0]，才能计算往下面的东西
    for (i in 1 until ver) {
        if (obstacleGrid[i][0] == 1) dp[i][0] = 0
        else dp[i][0] = dp[i - 1][0]
    }
    //同dp[i][0],dp[0][i]也得计算出来
    for (i in 1 until hor) {
        if (obstacleGrid[0][i] == 1) dp[0][i] = 0
        //然后就是dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        else dp[0][i] = dp[0][i - 1]
    }

    for (i in 1 until ver) {
        for (j in 1 until hor) {
            if (obstacleGrid[i][j] == 1) {
                dp[i][j] = 0
                continue
            }
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }
    return dp[ver - 1][hor - 1]
}