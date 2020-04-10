package com.moviesguo.leetcode.string

import sun.net.idn.StringPrep
import java.lang.StringBuilder

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，
 * 而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */

fun main() {
    println(intToRoman(3999))
}

//贪心算法版本
// 例如 3999 > nums[0]
// 添加 M
// curNum = 2999
// 添加M
// curNum = 1999
// 添加M
// curNum = 999 跳出内层循环 index++
// 添加CM
// curNum = 99 跳出内存循环 index++
//就这样
fun intToRomanGreedy(num:Int):String{
    var curNum = num
    //上面的数值和下面的罗马数字要对应,而且要从大到小排列
    val nums = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    //列出可能存在的所有情况
    val romans = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    var ans = StringBuilder()
    var index = 0
    //遍历nums
    while (index < 13) {
        //如果当前的值大于等于nums[index]
        while (curNum >= nums[index]) {
            //添加进去

            ans.append(romans[index])
            //然后当前值减去nums[index]
            curNum -= nums[index]
        }
        index++
    }
    return ans.toString()
}

fun intToRoman(num: Int): String {
    var n = num
    //不断地去找每一位数对应地罗马数字值，dp是10，100，1000，3000时后对应地罗马数字地值
    val dp = arrayOf(arrayOf("I","V"), arrayOf("X" ,"L"), arrayOf("C","D"), arrayOf("M","M"))
    var level = 0
    val sb = StringBuilder()
    while (n != 0) {
        val sub = n % 10
        n /= 10
        var subString = ""
        //小于四就加每位相当于1的那个数
        if (sub < 4) repeat(sub){ subString += dp[level][0]}
        //等于四就是每位的1+每位的5
        if (sub == 4) subString = "${dp[level][0]}${dp[level][1]}"
        //5-8就是 每位的5 + sub-5个每位的1
        if (sub in 5 until 9) {
            subString += dp[level][1]
            repeat(sub - 5) { subString += dp[level][0] }
        }
        //9就需要向下一位借位然后在左边在加上这一位的1
        if (sub == 9) {
            subString += "${dp[level][0]}${dp[level + 1][0]}"
        }
        sb.insert(0,subString)
        level++
    }
    return sb.toString()
}