package com.moviesguo.algorithm.dynamic_planning

/*
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */

/**
 * 动态规划
 */

/**
 * 好似大概明白了动态规划的意思
 *
 * 动态规划应该是将一个大问题拆解成一个一个的小问题,然后下放给每一步自己去处理,这点和递归的思路很像
 *
 * 这道题的思路就是将你想到达位置的的上一步的最短距离计算出来,然后选出来最短的那步就是到达该位置的最短路径
 *
 * ** 状态转换方程 **
 * db[i][j](路径的长度) = grid[i][j](加上当前位置自己的长度) + Math.min(grid[i][j-1],grid[i-1][j])(上一步的最短路径)
 *
 * Ps: 下面这个解法不是完全按照状态转换方程实现了,多考虑了边界的情况,因为在i/j为0的时候,i-1/j-1是越界了的
 * 如果完全按照状态转换方程去实现的话可以直接让越界的数字为Int.MAX_VALUE
 * 由于只能向右或者向下走,所以对于 grid[i][j]来说,从左上角到他的位置就是 Math.min(grid[i-1][j],grid[i][j-1])
 * 如果是在边界的情况下, 上边界 grid[0][j] 只能是上一步向右走才能到达 所以 grid[0][j] = gride[i][j-1]
 *                    左边界 grid[0][j] 只能是上一步向下走才能到达 所以 grid[0][j] = gride[i-1][j]
 *
 */
fun minPathSum(grid: Array<IntArray>): Int {
    for (i in 0 until grid.size) {
        for (j in 0 until grid[0].size) {
            if (i == 0 && j == 0) continue
            else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j]
            else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j]
            else grid[i][j] = Math.min(grid[i - 1][j] + grid[i][j], grid[i][j - 1] + grid[i][j])
        }
    }
    return grid[grid.size - 1][grid[0].size - 1]
}

