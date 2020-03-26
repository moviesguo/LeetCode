package com.moviesguo.algorithm.string

/**
 *
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 *
 * 实现一个将字符串进行指定行数变换的函数:
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 *
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 *
 *  A B
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * P     H
 * A   S I
 * Y  I  R
 * P L   I G
 * A     N
 */

fun main(args: Array<String>) {

    println(convert("PAYPALISHIRINGFSAHNFJKASGHQWEJADSKASDHJKCZXBNMASDHKWQE", 2))

}

fun convert(s: String, numRows: Int): String {

    if (numRows==1) return s

    var result = ""

    var isZ = true

    var index = 0

    var i = 0

    while (i < numRows) {

        if (index >= s.length) {
            i++
            index = i
            isZ = true
            continue
        }

        if (isZ) {
            result += s[index]

            println("index : $index i: $i str: ${s[index]} isZ: $isZ length:${(numRows - 1 - i)*2}")

            index += (numRows - 1 - i)*2
            isZ =false

            if (i == numRows-1) index+= i*2

        } else {
            if (i==0){

                result+=s[index]

                println("index : $index i: $i str: ${s[index]} isZ: $isZ")

                index+= (numRows - 1 - i)*2

                continue
            }

            println("index : $index i: $i str: ${s[index]} isZ: $isZ")

            result+=s[index]

            index+= i*2

            isZ = true
        }
    }

    return result
}



