package com.moviesguo.leetcode.dynamic_planning

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 */

fun main() {
    println(generateParenthesis(1).toString())
}

fun generateParenthesis(n: Int): List<String> {
    foo(n,n,"")
    return ans
}

val ans = ArrayList<String>()

/**
 * 一定是先加左再加右，如果右边加的比左边多，肯定就是无效的括号了
 * m,n分别代表左右还能加多少个,然后每次都尝试先加左还是先加右
 */
fun foo(m:Int,n:Int,cur:String){
    if (m > n) return
    if (m == 0 && n == 0) {
        ans.add(cur)
        return
    }
    if (m < 0 || n < 0) return
    foo(m - 1,n,"$cur(")
    foo(m,n - 1,"$cur)")
}


/**
 * 两年前写的
 */
fun generate(l:Int,r:Int,max:Int,cur:String){
    if (cur.length == max *2){
        ans.add(cur)
        return
    }
    //还是尝试一下先加左或者先加右
    //如果l还能加就能
    if (l < max) generate(l + 1, r, max, "$cur(")
    //如果左括号加的比较多，可以添加右括号
    if (l > r) generate(l, r + 1, max, "$cur)")
}