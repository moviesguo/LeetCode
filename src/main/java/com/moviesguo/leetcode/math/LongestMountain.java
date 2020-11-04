package com.moviesguo.leetcode.math;

import java.util.Arrays;

/**
 * @author guo on 2020/10/25.
 * @project LeetCode
 * 845.数组中的子最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i< B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉”的长度。
 *
 * 如果不含有 “山脉”则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 */

public class LongestMountain {

    public static void main(String[] args) {
        int[] A = {2,1,4,7,3,2,5};
        LongestMountain longestMountain = new LongestMountain();
        longestMountain.longestMountain(A);
    }

    public int longestMountain(int[] A){
        int n = A.length;
        if (n < 3) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; ++i) {
            //如果左边的小于当前值，那么当前值就是左边的高度+1
            //如果左边的大于当前值，那么当前这个位置应该是一个之前的下坡，或者另一个上坡的起始
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        for (int i = n - 2; i >= 0; --i) {
            //差不多同上
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            //思路还是和下面一样
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }


//    枚举山脚
//    public int longestMountain(int[] A) {
//        int maxLength = 0;
//        int i = 1;
//        while(i < A.length){
//            int increasing = 0,decreasing = 0;
//            //比较前一个是否比自己自己小，如果小的话这就是一个上坡的过程
//            while(i < A.length && A[i-1] < A[i]){
//                i++;
//                increasing++;
//            }
//            //找到这里是上坡结束了，下面是下坡的过程
//            while(i < A.length && A[i - 1] > A[i]){
//                i++;
//                decreasing++;
//            }
//            //如果只有上下坡其中之一，那么就不算了
//            if(increasing > 0 && decreasing > 0){
//                maxLength = Math.max(maxLength,increasing+decreasing+1);
//            }
//            //i在不断的增加，走过的上下坡都是确定的，不需要再去回溯了,可以直接从新的i开始找另一个山坡
//            while(i < A.length && A[i-1] == A[i]) i++;
//        }
//        return maxLength;
//    }

}
