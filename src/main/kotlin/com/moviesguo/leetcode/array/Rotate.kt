package com.moviesguo.algorithm.array

/*
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */

fun main() {
//    var a = intArrayOf(5,1,9,11)
//    var b = intArrayOf(2,4,8,10)
//    var c = intArrayOf(13,3,6,7)
//    var d = intArrayOf(15,14,12,16)

//    var a = intArrayOf(1, 2, 3)
//    var b = intArrayOf(4,5,6)
//    var c = intArrayOf(7,8,9)

//    var a = intArrayOf(1,2,3,4,5)
//    var b = intArrayOf(6,7,8,9,10)
//    var c = intArrayOf(11,12,13,14,15)
//    var d = intArrayOf(16,17,18,19,20)
//    var e = intArrayOf(21,22,23,24,25)

    var a = intArrayOf(1)

    var matrix = arrayOf(a)

    rotate(matrix)
}



fun rotate(matrix: Array<IntArray>): Unit {

    var start = 0
    var end = matrix.size - 1

    //先将i 和 size - i 行进行交换
    while (start < end) {
        swapRow(matrix, start, end)
        start++
        end--
    }
    //然后再对角交换
    for (i in 0 until matrix.size ) {
        var j = i + 1
        while (j != matrix.size) {
            swap(matrix, intArrayOf(i, j), intArrayOf(j, i))
            j++
        }
    }
    printMatrix(matrix)
}

fun printMatrix(matrix: Array<IntArray>) {
    matrix.forEach {
        println(it.contentToString())
    }
}

/**
 * 交换行位置
 */
fun swapRow(matrix: Array<IntArray>, i: Int, j: Int) {
    var temp = matrix[i]
    matrix[i] = matrix[j]
    matrix[j] = temp
}


/**
 * 交换位置
 */
fun swap(matrix: Array<IntArray>, i: IntArray, j: IntArray) {
    println("交换 ${i.contentToString()} -> ${j.contentToString()}")

    var temp = matrix[i[0]][i[1]]
    matrix[i[0]][i[1]] = matrix[j[0]][j[1]]
    matrix[j[0]][j[1]] = temp
}