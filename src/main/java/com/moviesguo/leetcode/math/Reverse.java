package com.moviesguo.leetcode.math;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例1:
 *
 * 输入: 123
 * 输出: 321
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[−231, 231− 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 *
 *
 */
public class Reverse {

    public int reverse(int x) {
        int ans = 0;
        boolean isNegative = x < 0;
        while(x != 0){
            int num = x%10;
            if(isNegative && (ans < (Integer.MIN_VALUE  - num)/ 10)) return 0;
            else if(!isNegative && (ans > (Integer.MAX_VALUE - num)/ 10 )) return 0;
            //这样不需要判断正负
            // if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && num < -8)) return 0;
            // if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && num > 7) ) return 0;
            ans = ans * 10 + num;
            x/=10;
        }
        return ans;
    }
}
