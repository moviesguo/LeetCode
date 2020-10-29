package com.moviesguo.leetcode.string;

import java.util.Arrays;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows =4
 * 输出:"LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class ZConvert {

    public static void main(String[] args) {
        ZConvert convert = new ZConvert();
        String ans = convert.convert("PAYPALISHIRING", 4);
        System.out.println(ans);
        System.out.println("LDREOEIIECIHNTSG");
        System.out.println(ans == "LDREOEIIECIHNTSG");
    }

    public String convert(String s, int numRows) {
        //rows = 1 就直接返回原字符串
        if (numRows == 1) return s;
        int row = numRows;
        //边界判断好费劲啊
        //halfZ 表示有多少个半个Z, numRows * 2 - 2 表示的是半个Z需要的字符数量
        int halfZ = s.length() / (numRows * 2 - 2);

        int column = 0;
        //如果半个Z的数量是0个,考虑有两种情况
        if (halfZ == 0) {
            // 1. s.length < numRows 这样是Z竖下来那笔都不够,那么就直接是1
            // 2. s.length > numRows 这样可能就是Z的转角没有花完,这个时候就是 s.length() - numRows 就是拐角的col值，再加上竖的那一下
            column = (Math.max((s.length() - numRows), 0)) + 1;
        } else {
            column = halfZ * (numRows * 2 - 2) + (s.length() % halfZ == 0 ? 0 : 1);
        }
        char[][] matrix = new char[row][column];
        int curCow = 0;
        int curCol = 0;
        boolean isCorner = false;
        for(int i = 0;i < s.length();++i){
            matrix[curCow][curCol] = s.charAt(i);
            //如果到了最下面了,就按拐角的方式处理
            if(curCow == numRows - 1){
                isCorner = true;
            }else if(curCow == 0){
                //如果到了最上面，按竖来处理
                isCorner = false;
            }
            //如果是拐角的话,每次cow+1,col-1
            if(isCorner){
                curCol += 1;
                curCow -= 1;
            }else{
                //不是拐角就每次cow+1
                curCow += 1;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char[] chars : matrix) {
            for (char c : chars) {
                if (c != 0) builder.append(c);
            }
            System.out.println();
        }
        return builder.toString();
    }

}
