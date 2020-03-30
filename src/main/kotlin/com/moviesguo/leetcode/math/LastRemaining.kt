package com.moviesguo.leetcode.math

import linked_list.ListNode

/**
 * 面试题62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 */

fun main() {
    println(lastRemaining(70866, 116922))
}

/**
 * 参考https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/huan-ge-jiao-du-ju-li-jie-jue-yue-se-fu-huan-by-as/
 *
 * 设 n = 8,m = 3
 * A B C D E F G H 第一次C被移除  N = 8
 * D E F G H A B  然后从D开始   N = 7
 * G H A B D E    然后 A 被移除 从G 开始
 *
 * 以此类推，最后剩下一个人的时候，他的index必为0 (index指假设上面这些是一个数组)
 * 所以我们反推一下 N=7 -> N=8的过程
 * 1.  先将被移除的C加到数组最后面  D E F G H A B C 再将数组向右移动m次也就是3次
 * 最后结果 A B C D E F G H 就回到了N=8
 *  这里其实不需要关心移除和添加的是谁 我们只关心最后一个剩下数字的位置变化
 *  由上面的推论可以得出 f(n,m) = (f(n-1,m) + m) % n，递归下去就好了
 */
fun lastRemaining(n: Int, m: Int): Int {
    var f = 0
    var i = 2
    while (i != n + 1) {
        f = (m + f) % i
        i++
    }
    return f
}

/**
 * timeout
 */
//fun lastRemaining(n: Int, m: Int): Int {
//    val root = ListNode(0)
//    var cur :ListNode? = root
//    for (i in 1 until n) {
//        cur?.next = ListNode(i)
//        cur = cur?.next!!
//    }
//    cur?.next = root
//    cur = root
//    while (cur?.next != null) {
//
//        if (m < 2) {
//            val next = cur?.next
//            cur?.`val` = next!!.`val`
//            cur?.next = cur?.next?.next
//            next.next = null
//        } else {
//            repeat(m - 2) {
//                cur = cur?.next!!
//            }
//            val temp = cur?.next
//            cur?.next = cur?.next?.next
//            temp?.next = null
//            if (cur?.next != null) {
//                cur = cur!!.next
//            }
//        }
//    }
//    return cur!!.`val`
//}