package com.moviesguo.leetcode.string

import sun.net.idn.StringPrep
import java.lang.StringBuilder
import java.util.*

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 */

fun main(){
    println(reverseWords("world! hello"))
}

fun reverseWords(s: String): String {
    val ans = StringBuilder()
    s.split("\\s+".toRegex()).reversed().forEach {
        if (it.isNotBlank()){
            ans.append(it)
            ans.append(" ")
        }
    }
    ans.trim().toString()
    return s.trim().split("\\s+".toRegex()).reversed().joinToString(separator = " ")
}

//同下面的方法
//fun reverseWords(s: String): String {
//    val sb = StringBuilder()
//    var cur  = StringBuilder()
//    s.indices.forEach { i ->
//        //不是空格就添加进去
//        if (!s[i].isWhitespace() ) {
//            cur.append(s[i])
//        } else if (s[i].isWhitespace()) {
//            if (cur.isNotEmpty()) {
//                if (sb.isEmpty()) {
//                    //第一个添加后面不带空格
//                    sb.insert(0, cur.toString())
//                    //清空
//                    cur.clear()
//                } else {
//                    //后面添加就都带着空格了
//                    cur.append(" ")
//                    //添加到最前面
//                    sb.insert(0, cur.toString())
//                    cur.clear()
//                }
//            }
//        }
//    }
//    if (cur.isNotEmpty()) if (sb.isEmpty()) {
//        sb.insert(0, cur.toString())
//        cur.clear()
//    } else {
//        cur.append(" ")
//        sb.insert(0, cur.toString())
//        cur.clear()
//    }
//    return sb.toString()
//}

/**
 * 找到空格看看是不是已经是第二次找到了，如果是那么就加到前面去,如果不是第一次添加需要带着空格
 */
//fun reverseWords(s:String):String{
//    val sb = StringBuilder()
//    var start = 0
//    var b = false
//    s.indices.forEach { i ->
//        if (!s[i].isWhitespace() && !b) {
//            start = i
//            b = true
//        } else if (s[i].isWhitespace() && b) {
//            if (sb.isEmpty()) {
//                sb.insert(0, s.substring(start, i))
//            } else {
//                sb.insert(0, s.substring(start, i) + " ")
//            }
//            b = false
//        }
//    }
//
//    if (b)   if (sb.isEmpty()) {
//        sb.insert(0, s.substring(start,s.length))
//    } else {
//        sb.insert(0, s.substring(start, s.length) + " ")
//    }
//    return sb.toString()
//}