package com.moviesguo.leetcode.array;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在0 < i< A.length - 1条件下，存在i使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        int[] a = new int[]{2,1,2,3,5,7,9,10,12,14,15,16,18,14,13};
        System.out.println(validMountainArray.validMountainArray(a));
    }

    /**
     * 我怎么这么蠢
     * 先向左扫描找到最高的，如果最高的是0或者最后一个，那么就不是山脉了
     * 然后从i开始找，看看i右边是不是递减的，如果不是那就不是山脉了
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }

    public boolean validMountain(int[] A) {
        if (A.length < 3) return false;
        int left = 0;
        int right = A.length - 1;

        // 注意防止越界
        while (left < A.length - 1 && A[left] < A[left + 1]) left++;

        // 注意防止越界
        while (right > 0 && A[right] < A[right - 1]) right--;

        // 如果left或者right都在起始位置，说明不是山峰
        if (left == right && left != 0 && right != A.length - 1) return true;
        return false;
    }

}
