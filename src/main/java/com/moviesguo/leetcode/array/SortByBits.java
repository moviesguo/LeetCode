package com.moviesguo.leetcode.array;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中1的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 *
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 *
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 *
 */
public class SortByBits {

    public static void main(String[] args) {
        SortByBits sortByBits = new SortByBits();
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8};
        int[] sorted = sortByBits.sortByBits(arr);
        System.out.print("[ ");
        for (int num : sorted) {
            System.out.print(num+" ");
        }
        System.out.print("]");
    }

    public int[] sortByBits(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        quickSort(arr, left, right);
        return arr;
    }

    //快速排序
    public void quickSort(int[] arr,int left,int right){
        if(left >= right) return;
        int start = left;
        int end = right;
        //选取第一个为基准点
        int temp = arr[start];
        while(left != right){
            //先找到后面比基准点小的数
            while (compareTo(arr[right], temp) && right > left) {
                right--;
            }
            //再找到前面比基准点大的数 这里都要主要 left和right的值
            while (compareTo(temp,arr[left]) && left < right) {
                left++;
            }
            //两个数互换位置
            if (left < right) {
                int num = arr[left];
                arr[left] = arr[right];
                arr[right] = num;
            }
        }
        //再把基准点和left、right相交的位置互换
        int num = arr[left];
        arr[start] = num;
        arr[left] = temp;
        quickSort(arr,start,left - 1);
        quickSort(arr,left + 1,end);
    }

    //比较两个二进制数目排序
    public boolean compareTo(int num1,int num2){
        int bitsCount1 = getBitsCount(num1);
        int bitsCount2 = getBitsCount(num2);
        if(bitsCount1 > bitsCount2) return true;
        else if(bitsCount2 > bitsCount1) return false;
        else return num1 >= num2;
    }

    public int getBitsCount(int num){
        int count = 0;
        while(num != 0){
//            if(num % 2 == 1) count++;
            count += (num % 2);
            num/=2;
        }
        return count;
    }

}
