package array

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 */
/**
 *
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty()) return false
    val m = matrix.size
    val n = matrix[0].size
    //当作一个数组去二分搜索
    // matrix[index] = matrix[index/n][index%n]
    //我太菜了
    var left = 0
    var right = m * n - 1
    while (left <= right) {
        val center = (left + right) / 2
        val value = matrix[center / n][center % n]
        if (value == target) {
            return true
        }
        if (target < value ) {
            right = center - 1
        } else {
            left = center + 1
        }
    }
    return false
}
