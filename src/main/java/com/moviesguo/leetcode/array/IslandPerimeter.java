package com.moviesguo.leetcode.array;

/**
 * 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid){
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    /**
     * 深度优先搜索其实还是去找四周是不是水
     * @param grid
     * @param row
     * @param col
     * @return
     */
    public int dfs(int[][] grid, int row, int col) {
        //边界判断
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
            return 0;
        }
        //如果碰到了水路，就返回+1
        if (grid[row][col] == 0){
            return  1;
        }
        //如果还是岛屿就不加了
        if (grid[row][col] == 1){
            return 0;
        }
        grid[row][col] = 2;
        return dfs(grid, row + 1, col) +
                dfs(grid, row - 1, col) +
                dfs(grid, row, col + 1) +
                dfs(grid, row, col - 1);
    }

//    //遍历去找四周的不是岛屿的就是周长
//    public int islandPerimeter(int[][] grid) {
//        int row = grid.length;
//        int col = grid[0].length;
//        if(row == 0 || col == 0) return 0;
//        int length = 0;
//        for(int i = 0;i < row;++i){
//            for(int j = 0;j < col;++j){
//                if(grid[i][j] == 0) continue;
//                int left = j - 1;
//                int right = j + 1;
//                int top = i - 1;
//                int bottom = i + 1;
//                if(left < 0 || grid[i][left] != 1) length++;
//                if((right < col && grid[i][right] != 1) || right == col) length++;
//                if(top < 0 || grid[top][j] != 1) length++;
//                if((bottom < row && grid[bottom][j] != 1) || bottom == row) length++;
//                System.out.println(i + "," + j + " length : " + length );
//            }
//        }
//        return length;
//    }
}
