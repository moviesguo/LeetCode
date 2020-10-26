package com.moviesguo.leetcode.array;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2,5,5,11};
        twoSum.twoSum(nums,10);
    }

    //将 target - nums[i] 存起来
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            //先找，然后再存，如果有target-nums[i]会在后面出现的话，那么也是能对应上的
            if (map.containsKey(target - nums[i])) {
                //由于只有唯一解，才可以这么做
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }

    //    //暴力法
//    public int[] twoSum(int[] nums, int target) {
//        int length = nums.length;
//        for (int i = 0;i < length;++i){
//            int temp = target - nums[i];
//            for (int j = 0; j < length; ++j) {
//                if (i == j) continue;
//                if (nums[j] == temp) return new int[]{i, j};
//            }
//        }
//        return null;
//    }

}
