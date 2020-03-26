package com.moviesguo.algorithm.dynamic_planning

import com.sun.xml.internal.fastinfoset.util.StringArray

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 */

fun main() {

    var s = "applepenapple"
    var wordDict = arrayListOf<String>("cats", "dog", "sand", "and", "cat")
    println(wordDict.firstOrNull { it == "san" })

}

/**
 *
 *  动态规划
 *
 *  s[i] 为 i个字符的时候是否存在可以切割的
 *
 *  s[i] = 需要找到 s[0~i] && w.contains(s.subString((0~i),i)),因为可能存在 2+4/3+3这样的情况
 *
 * s[i] = s[i-j](j in 0 until i) && w.contains(s.subString(j,i))
 *
 *
 */
fun wordBreak(s: String, wordDict: List<String>): Boolean {

    var d: Array<Boolean?> = arrayOfNulls(s.length + 1)

    d[0] = true

    for (i in 1..s.length) {

        for (j in 0 until i) {
            if (d[j] == true && wordDict.contains(s.substring(j, i))) {
                d[i] = true
                break
            }
        }

    }
    return d[s.length]?:false
}