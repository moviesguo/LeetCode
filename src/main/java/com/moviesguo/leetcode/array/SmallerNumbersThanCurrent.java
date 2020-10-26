package com.moviesguo.leetcode.array;

import java.util.Arrays;

/**
 *
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
 *
 * 以数组形式返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *
 */
public class SmallerNumbersThanCurrent {

    //计数排序
    //因为nums中的数是有一个区间的，所以可以用计数排序
    //先用counts记录所有的数存在的数量
    //然后在计算每个数有多少比自己小的
    //最后再把lessThan和nums对应起来就是结果了
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num] = counts[num] + 1;
        }
        int[] lessThan = new int[101];
        int temp = 0;
        for (int i = 0;i < 101;++i){
            lessThan[i] = temp;
            temp += counts[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i< nums.length;++i){
            res[i] = lessThan[nums[i]];
        }
        return res;
    }

//        暴力法
//        public int[] smallerNumbersThanCurrent(int[] nums){
//        int length = nums.length;
//        int[] lengths = new int[length];
//        Arrays.fill(lengths,0);
//        for(int i =0; i < length; ++i){
//            for(int j = 0 ; j < length; ++j){
//                if(i == j) continue;
//                if(nums[i] > nums[j]) lengths[i] = lengths[i] +1;
//            }
//        }
//        return lengths;
//    }

}
