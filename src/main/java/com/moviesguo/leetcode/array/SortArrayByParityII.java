package com.moviesguo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParityII {

    /**
     * 原地算法
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                //如果到了奇数就不断找奇数索引不是奇数的索引
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    /**
     * 建立两个索引分别指向下一个偶数/奇数要放在的位置
     * @param A
     * @return
     */
//    public int[] sortArrayByParityII(int[] A) {
//        int[] ans = new int[A.length];
//        int oddIndex = 1;
//        int evenIndex = 0;
//        for(int i = 0;i < A.length;++i){
//            if(A[i] % 2 == 0){
//                ans[evenIndex] = A[i];
//                evenIndex+=2;
//            }else{
//                ans[oddIndex] = A[i];
//                oddIndex+=2;
//            }
//        }
//        return ans;
//    }

    /**
     * 把奇数偶数分别加到不同的集合去，然后再重新添加回来
     * @param A
     * @return
     */
//    public int[] sortArrayByParityII(int[] A) {
//        List<Integer> odd = new ArrayList<>();
//        List<Integer> even = new ArrayList<>();
//        for(int num : A){
//            if(num % 2 == 0) even.add(num);
//            else odd.add(num);
//        }
//        int[] ans = new int[A.length];
//        for(int i = 0;i < A.length;++i){
//            if(i % 2 == 0) ans[i] = even.remove(0);
//            else ans[i] = odd.remove(0);
//        }
//        return ans;
//    }

}
