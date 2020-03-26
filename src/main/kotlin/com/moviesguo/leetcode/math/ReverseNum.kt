package com.moviesguo.algorithm.math

/**
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。

 * 示例 1:

 * 输入: 123
 * 输出: 321
 * 示例 2:

 * 输入: -123
 * 输出: -321
 * 示例 3:

 * 输入: 120
 * 输出: 21
 * 注意:

 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 */


fun main(args: Array<String>) {
    println(reverse(-2147483648))
}

fun reverse(x: Int) :Int{

    var temp = x
    var res = 0

    while (temp!=0) {
        var i = temp % 10
        temp /= 10
        if (res > Int.MAX_VALUE / 10 || (res == Int.MAX_VALUE) && i > 7) return 0
        if (res < Int.MIN_VALUE / 10 || (res == Int.MIN_VALUE / 10) && i < -8) return 0
        res = res * 10 + i
        println(res)
    }

    return res

}