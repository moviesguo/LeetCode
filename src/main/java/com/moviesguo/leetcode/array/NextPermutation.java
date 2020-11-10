package com.moviesguo.leetcode.array;


/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从后先前招到第一个小于后面数的位置
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            //这个时候再去从后向前找比nums[i]大的第一个数，也就是第一个大于它的数
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            //然后交换位置
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        //这个时候i之后的都是降序排列的，把他反转一下就是最小的了
        reverse(nums,i+1);
    }

    private void reverse(int[] nums,int start){
        int begin = start;
        int end = nums.length - 1;
        while(begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }


//    // 不需要快排出马
//    private void quickSort(int[] nums,int start,int end){
//        if(start >= end) return;
//        int target = nums[start];
//        int left = start;
//        int right = end;
//        while(left != right){
//            while(nums[right] >= target && left < right){
//                right--;
//            }
//            while(nums[left] <= target && left < right){
//                left++;
//            }
//            if(left > right){
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//            }
//        }
//        nums[start] = nums[left];
//        nums[left] = target;
//        quickSort(nums,start,left - 1);
//        quickSort(nums,left + 1,end);
//    }

}
