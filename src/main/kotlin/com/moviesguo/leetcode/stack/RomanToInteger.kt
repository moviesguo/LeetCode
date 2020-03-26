package com.moviesguo.algorithm.stack

import java.util.*

/**
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。

 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 *   I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 *   X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 *   C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *   给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *   示例 1:
 *
 *   输入: "III"
 *   输出: 3
 *    示例 2:
 *
 *   输入: "IV"
 *   输出: 4
 *    示例 3:
 *
 *   输入: "IX"
 *   输出: 9
 *   示例 4:
 *
 *   输入: "LVIII"
 *   输出: 58
 *    解释: C = 100, L = 50, XXX = 30, III = 3.
 *   示例 5:
 *
 *    输入: "MCMXCIV"
 *    输出: 1994
 *  解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */

fun main(args: Array<String>) {

    println(romanToInt("MMMCMXCIX"))


}

fun romanToInt(s: String): Int {

    var res = 0
    var stack:Stack<Char> = Stack()

    for (item in s){
        if (stack.isEmpty()) {
            stack.push(item)
            continue
        }
        //不删除栈顶的值
        if (compareTo(stack.peek(), item)) {
            res += getCombinationValue(stack.pop(), item)
        } else {
            res += getValue(stack.pop())
            stack.push(item)
        }
    }
    if (!stack.isEmpty()) res += getValue(stack.pop())
    return res

}


fun getValue(c:Char):Int = when(c){

    'I' -> 1
    'V' -> 5
    'X' -> 10
    'L' -> 50
    'C' -> 100
    'D' -> 500
    'M' -> 1000
    else -> 0

}

fun getCombinationValue(c1:Char, c2:Char):Int = when{
    c1=='I'&&c2=='V' ->4
    c1=='I'&&c2=='X' -> 9
    c1=='X'&&c2=='L' ->40
    c1=='X'&&c2=='C' ->90
    c1=='C'&&c2=='D' -> 400
    c1=='C'&&c2=='M' ->900
    else -> 0
}

fun compareTo(c1: Char, c2: Char):Boolean = when{

    c1=='I'&&c2=='V' ->true
    c1=='I'&&c2=='X' -> true
    c1=='X'&&c2=='L' ->true
    c1=='X'&&c2=='C' ->true
    c1=='C'&&c2=='D' -> true
    c1=='C'&&c2=='M' ->true
    else -> false

}
