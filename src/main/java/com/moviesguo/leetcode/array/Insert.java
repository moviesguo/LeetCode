package com.moviesguo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 *
 */
public class Insert {

    public static void main(String[] args) {
        Insert insert = new Insert();
        System.out.println(insert.insert(new int[][]{{1}, {2}}, new int[]{1, 2}));
    }

    /**
     * 日常好菜
     * 如果两个区间 l1,r1 l2,r2
     * r1 < l2 || l1 > r2 那么就是这两个区间不相交
     * 剩下的区间的交集为 [Math.min(l1,l2) , Math.max(r1,r2)]
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList();
        int row = intervals.length;
        int left = newInterval[0];
        int right = newInterval[1];
        boolean isPlaced = false;
        for(int[] interval : intervals){
            if(interval[0] > right){
                if(!isPlaced){
                    ans.add(new int[]{left,right});
                    isPlaced = true;
                }
                ans.add(interval);
            }else if(interval[1] < left){
                ans.add(interval);
            }else {
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if(!isPlaced){
            ans.add(new int[]{left,right});
        }
        int[][] res = new int[ans.size()][2];
        for(int i = 0;i < ans.size();++i){
            res[i] = ans.get(i);
        }
        return res;
    }
}
