package array

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
fun main() {
//    val a = intArrayOf(2,5)
//    val b = intArrayOf(8,4)
//    val c = intArrayOf(0,-1)
//    val a = intArrayOf(1,2,3)
//    val b = intArrayOf(4,5,6)
//    val c = intArrayOf(7,8,9)

    val a = intArrayOf(3)
    val b = intArrayOf(2)

    val array = arrayOf(a,b)
    println(spiralOrder(array))
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if (matrix.isEmpty()) return emptyList()
    if (matrix.size == 1) return matrix[0].toList()

    var left = 0
    var right = matrix[0].size - 1
    var top = 0
    var bottom = matrix.size - 1

    var ver = 0
    var hor = 0
    //可能上来就要向下找
    var type = if (right == 0) 1 else 0

    val ans = ArrayList<Int>()
    while (ver <= bottom || hor <= right) {
        println("left $left right $right top $top bottom $bottom ver $ver hor $hor")
        println("添加节点${matrix[ver][hor]}")

        ans.add(matrix[ver][hor])
        if (top > bottom) break
        if (left > right) break
        when (type) {
            //右
            0 -> {
                hor++
                if (hor == right) {
                    top++
                    type = (type + 1) and 3
                }
            }
            //下
            1 -> {
                ver++
                if (ver == bottom) {
                    right--
                    type = (type + 1) and 3
                }
            }
            //左
            2 -> {
                hor--
                if (hor == left) {
                    bottom--
                    type = (type + 1) and 3
                }
            }
            //上
            3 -> {
                ver--
                if (ver == top) {
                    left++
                    type = (type + 1) and 3
                }
            }
        }
    }
    return ans
}

fun foo(matrix: Array<IntArray>):List<Int> {
    val ans =  ArrayList<Int>();
    if (matrix.size == 0) return ans;
    val R = matrix.size
    val C = matrix[0].size
    val seen = Array(R) { Array<Boolean>(C) { false } }
    //这样规定之后，就是 和我的思路一样，右->下->左->上
    val dr = intArrayOf(0, 1, 0, -1)    //用于配合di判断自己的移动方向,竖直移动方向
    val dc = intArrayOf(1, 0, -1, 0)    //用于配合di判断自己的移动方向,水平移动方向

    var r = 0
    var c = 0
    var di = 0
    for (i in 0 until R * C) {
        ans.add(matrix[r][c])
        seen[r][c] = true
        val cr = r +dr[di]
        val cc = c +dc[di]
        //先做边界判断，如果要超出边界了就改变方向
        if (cr in 0 until R && 0 <= cc && cc < C && !seen[cr][cc]) {
            r = cr
            c = cc
        } else {
            //修改移动方法
            di = (di + 1) % 4
            r += dr[di]
            c += dc[di]
        }
    }
    return ans;
}