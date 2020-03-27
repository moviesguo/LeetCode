package array

/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），
 * 然后朝那个方向移动，直到它选择停止
 * 、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
 * 另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 *  
 *
 * 示例 1：
 * 输入：
 * [[".",".",".",".",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".","R",".",".",".","p"],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 在本例中，车能够捕获所有的卒。
 *
 */
fun numRookCaptures(board: Array<CharArray>): Int {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    var i = 0
    for (i in 0 until 8) {
        var j = 0
        for (j in 0 until 8)
        // 找到白车所在的位置
            if (board[i][j] == 'R') {
                // 分别判断白车的上、下、左、右四个方向
                var res = 0
                var k = 0
                for (k in 0 until 4) {

                    var x = i
                    var y = j;
                    while (true) {
                        x += dx[k];
                        y += dy[k];
                        if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B') {
                            break
                        }
                        if (board[x][y] == 'p') {
                            res++
                            break
                        }
                    }
                }
                return res
            }
    }
    return 0
}