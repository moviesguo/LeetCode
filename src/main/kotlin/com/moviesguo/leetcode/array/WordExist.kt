package com.moviesguo.algorithm.array

/*
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:

 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * [["a","a","a","a"],["a","a","a","a"],["a","a","a","a"]]
"aaaaaaaaaaaaa"
 */

fun main() {

    var a = charArrayOf('a','a','a','a')
    var b = charArrayOf('a','a','a','a')
    var c = charArrayOf('a','a','a','a')

    var d = charArrayOf('a','b')
    var e = charArrayOf('c','d')

    var board = arrayOf(a,b,c)
    println(exist(board, "aaaaaaaaaaaaa"))

}

fun exist(board: Array<CharArray>, word: String): Boolean {

    var marked = Array(board.size){ BooleanArray(board[0].size)}

    for (i in 0 until board.size) {
        for (j in 0 until board[0].size) {
            if (exist(board, word, arrayOf(i, j), 0, marked)) return true
        }
    }
    return false
}

/**
 * 深度优先搜索 dfs
 */
fun exist(board: Array<CharArray>, word: String, local: Array<Int>,index:Int,mark:Array<BooleanArray>):Boolean {
    if (local[0] < 0 || local[0] == board.size || local[1] < 0 || local[1] == board[0].size) return false
    println("${word[index]} ${board[local[0]][local[1]]}")
    if (word[index]==board[local[0]][local[1]]) {
        mark[local[0]][local[1]] = true
        if (index == word.length - 1) return true
        else if (isVaild(local[0] - 1, local[1], board.size, board[0].size) && !mark[local[0] - 1][local[1]] && exist(board, word, arrayOf(local[0] - 1, local[1]), index + 1, mark)) return true
        else if (isVaild(local[0] + 1, local[1], board.size, board[0].size) && !mark[local[0] + 1][local[1]] && exist(board, word, arrayOf(local[0] + 1, local[1]), index + 1, mark)) return true
        else if (isVaild(local[0], local[1] - 1, board.size, board[0].size) && !mark[local[0]][local[1] - 1] && exist(board, word, arrayOf(local[0], local[1] - 1), index + 1, mark)) return true
        else if (isVaild(local[0], local[1] + 1, board.size, board[0].size) && !mark[local[0]][local[1] + 1] && exist(board, word, arrayOf(local[0], local[1] + 1), index + 1, mark)) return true
        else mark[local[0]][local[1]] = false
    }
    return false
}

fun isVaild(i: Int, j: Int,row:Int,col:Int):Boolean {
    return i in 0 until row && j in 0 until col

}