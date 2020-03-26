package com.moviesguo.algorithm.array

import kotlin.math.min

/**
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 *
 *
 */

fun main(args: Array<String>) {

    val strs:Array<String> = arrayOf("flower")
    println(longestCommonPrefix(strs))
}

fun longestCommonPrefix(strs: Array<String>): String {

    var minLength = -1


    for (i in 1 until strs.size) {
        if (minLength==-1) minLength = foo(strs, i, 1)
        else minLength = min(minLength, foo(strs, i, 1))
    }


    return strs[0].substring(0,minLength)
}

fun foo(strs: Array<String>, index: Int, length: Int) :Int{

    return when {
        length>strs[index].length -> length - 1
        strs[index].substring(0,length) == strs[0].substring(0,length) -> foo(strs, index, length + 1)
        length==1 -> 0
        else -> length - 1
    }
}
