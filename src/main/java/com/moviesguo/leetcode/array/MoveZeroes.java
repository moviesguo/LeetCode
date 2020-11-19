package com.moviesguo.leetcode.array;

/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int replaceIndex = 0;
        int i = 0;
        while(replaceIndex < nums.length){
            if(i == nums.length){
                while(replaceIndex < nums.length){
                    nums[replaceIndex++] = 0;
                }
                return;
            }
            if(nums[i] != 0){
                nums[replaceIndex] = nums[i];
                replaceIndex++;
            }
            i++;
        }
    }

}
