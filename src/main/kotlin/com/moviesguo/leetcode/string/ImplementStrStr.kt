package com.moviesguo.algorithm.string

/**
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 */

fun main(args: Array<String>) {

    println(strStr("hello", "ll"))

}

fun strStr(haystack: String, needle: String): Int {

    if (needle.isEmpty()) return 0
    if (haystack.length<needle.length) return -1
    var res = -1

    for (i in 0 until haystack.length) {

        if (haystack[i] != needle[0]) continue

        var index = i

        for (j in 0 until needle.length){

            println("length: ${needle.length} j: $j")

            if (index>haystack.length-1) {
                res = -1
                break
            }
            if (haystack[index] == needle[j]) {
                index++
                println("相同 index: $index")
                if (j == needle.length - 1) {
                    res = i
                    break
                }
            } else {
                break
            }

        }
        println("循环次数$i")

        if (res == i) break
    }
    return res
}