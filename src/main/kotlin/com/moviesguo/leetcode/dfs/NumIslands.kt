package com.moviesguo.algorithm.dfs

/**
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 */

/**
 * 广度优先遍历,首先找到一个为1的节点，然后去他的四周做深度优先搜索
 * 截止条件为 越界或者找到的节点为0,如果不是0的就将它置为0
 * @link{url https://leetcode-cn.com/problems/number-of-islands/solution/number-of-islands-shen-du-you-xian-bian-li-dfs-or-/}
 */
fun numIslands(grid: Array<CharArray>): Int {
    var count = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == '1') {
                dfs(grid,i,j)
                count++
            }
        }
    }
    return count
}

fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
    if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || grid[i][j] == '0') return
    grid[i][j] = '0'
    dfs(grid, i + 1, j)
    dfs(grid, i, j + 1)
    dfs(grid, i - 1, j)
    dfs(grid, i, j - 1)
}