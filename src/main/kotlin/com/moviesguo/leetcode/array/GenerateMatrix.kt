package array

/**
 * 给定一个正整数 n，生成一个包含 1 到 n.pow(2) n的2次方 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 */

fun main() {
    println(generateMatrix(3))
}

fun generateMatrix(n: Int): Array<IntArray> {
    val ans = Array(n) { IntArray(n) { 0 } }
    var hor = 0
    val seen = Array(n) { Array<Boolean>(n) { false } }
    var ver = 0
    var di = 0
    var ov = intArrayOf(0, 1, 0, -1)
    var oh = intArrayOf(1, 0, -1, 0)

    for (i in 1 .. n*n){
        ans[ver][hor] = i
        seen[ver][hor] = true
        var nv = ver + ov[di]
        var nh = hor + oh[di]
        if (nh in 0 until n && nv in 0 until n && !seen[nv][nh]) {
            ver = nv
            hor = nh
        } else {
            di = (di + 1) % 4
            ver += ov[di]
            hor += oh[di]
        }

    }
    return ans
}