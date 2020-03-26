package array

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */

fun main() {
    val a = intArrayOf(1, 1, 1)
    val b = intArrayOf(1, 0, 1)
    val c = intArrayOf(1, 1, 1)
    val array = arrayOf(a, b, c)
    setZeroes(array)
    array.forEach {
        it.forEach {
            num->
            print(num)
        }
        println()
    }
}

fun setZeroes(matrix: Array<IntArray>): Unit {
    val ver = matrix.size
    val hor = matrix[0].size

    val verContain = IntArray(ver){ 0}
    val horContain = IntArray(hor) { 0}
    for (i in 0 until ver) {
        for (j in 0 until hor) {
            if (matrix[i][j] == 0){
                verContain[i] = 1
                horContain[j] = 1
            }
        }
    }

    for (i in 0 until ver) {
        for (j in 0 until hor) {
            if (verContain[i] == 1 || horContain[j] == 1) matrix[i][j] = 0
        }
    }

}
/**
 * 思路利用每一行的第一个和每列的第一个记录本行/列是否有0，如果有0就将第一个置为0，最后用它去遍历
 * 第一行第一列由于又是行又是列，所以用额外的两个参数来表示行是否有0或列是否有0
 */
//public void setZeroes(int[][] matrix) {
//    int row = matrix.length;
//    int col = matrix[0].length;
//    boolean row0_flag = false;
//    boolean col0_flag = false;
//    // 第一行是否有零
//    for (int j = 0; j < col; j++) {
//        if (matrix[0][j] == 0) {
//            row0_flag = true;
//            break;
//        }
//    }
//    // 第一列是否有零
//    for (int i = 0; i < row; i++) {
//        if (matrix[i][0] == 0) {
//            col0_flag = true;
//            break;
//        }
//    }
//    // 把第一行第一列作为标志位
//    for (int i = 1; i < row; i++) {
//        for (int j = 1; j < col; j++) {
//        if (matrix[i][j] == 0) {
//            matrix[i][0] = matrix[0][j] = 0;
//        }
//    }
//    }
//    // 置0
//    for (int i = 1; i < row; i++) {
//        for (int j = 1; j < col; j++) {
//        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//            matrix[i][j] = 0;
//        }
//    }
//    }
//    if (row0_flag) {
//        for (int j = 0; j < col; j++) {
//            matrix[0][j] = 0;
//        }
//    }
//    if (col0_flag) {
//        for (int i = 0; i < row; i++) {
//            matrix[i][0] = 0;
//        }
//    }
//}
