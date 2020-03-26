package com.moviesguo.algorithm.string

import java.lang.NumberFormatException
import java.lang.StringBuilder

/**
 *
 * 2019年10月08日16:39:06
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 */

fun main(args: Array<String>) {
    var s = " -42"
    println(myAtoi2(s))
}

fun myAtoi(str: String) :Int {
    if (str.isEmpty()) return 0
    var result = arrayOf(-1, -1)
    var chars = str.toCharArray()
    myAtoi(chars, 0, result)
    if (result[0] == -1) return 0
    if (result[0]==result[1]){
        return if (chars[result[0]].toInt() == 43 || chars[result[1]].toInt() == 45) 0
        else StringBuilder().append(chars[result[0]]).toString().toInt()
    }else{
        //判断是否超出了 INT.MAX_VALUE 或者 小于 INT.MIN_VALUE
        var resultString = str.substring(result[0], result[1] + 1)
        return try {
            resultString.toInt()
        } catch (e: NumberFormatException) {
            if (resultString.contains("-")) {
                Int.MIN_VALUE
            } else {
                Int.MAX_VALUE
            }
        }
    }
}



fun myAtoi(chars: CharArray,index:Int,result:Array<Int>) {
    if (index > chars.size - 1) return
    var char = chars[index].toInt()

    println("char ascii : $char")

    if (char == '+'.toInt() || char == '-'.toInt()) {
        //如果该位置的字符为 加号 减号的情况下,需要判断result的第一个位置是否已经开始查找连续数字
        println("找到+-号 index : $index")
        result[0] = index
        result[1] = index
        myAtoi(chars, index + 1, result)
    } else if (char > '9'.toInt() || char < '0'.toInt()) {
        //如果不是数字就结束查找
        println("停止查找")
        return
    } else {
        println("找到数字 ${chars[index]}")
        //剩下这里应该是数字的情况
        if (result[0] != -1) result[1] = index
        else {
            result[0] = index
            result[1] = index
        }
        myAtoi(chars, index + 1, result)
    }
}

fun myAtoi2(str: String): Int {

    if (str.isNullOrEmpty()) return 0
    //去掉空格
    var trimString = str.trim()
    var start = 0
    var res = 0L
    //确定数字的正负
    var sign = 1
    if (trimString[0] == '-') {
         sign = -1
        start++
    }

    if (trimString[0] == '+'){
        start++
    }

    //开始查找数字
    for (i in start until trimString.length) {
        //如果不是数字
        if (!Character.isDigit(trimString[i])) {
            return res.toInt() * sign
        }
        //计算当前最大的数字
        res = res * 10 + trimString[i].toInt() - '0'.toInt()
        //边界判断
        if (sign == 1 && res > Int.MAX_VALUE) return Int.MAX_VALUE
        if (sign == -1 && res > Int.MAX_VALUE) return Int.MIN_VALUE
    }
    return res.toInt() * sign
}


/**
 * 优化的版本
 */

//
//public int myAtoi(String str) {
//    str = str.trim();
//    if (str == null || str.length() == 0)
//        return 0;
//
//    char firstChar = str.charAt(0);
//    int sign = 1;
//    int start = 0;
//    long res = 0;
//    if (firstChar == '+') {
//        sign = 1;
//        start++;
//    } else if (firstChar == '-') {
//        sign = -1;
//        start++;
//    }
//
//    for (int i = start; i < str.length(); i++) {
//        if (!Character.isDigit(str.charAt(i))) {
//            return (int) res * sign;
//        }
//        res = res * 10 + str.charAt(i) - '0';
//        if (sign == 1 && res > Integer.MAX_VALUE)
//            return Integer.MAX_VALUE;
//        if (sign == -1 && res > Integer.MAX_VALUE)
//            return Integer.MIN_VALUE;
//    }
//    return (int) res * sign;
//}