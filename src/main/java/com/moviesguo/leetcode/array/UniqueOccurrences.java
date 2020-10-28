package com.moviesguo.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数
 * 给你一个整数数组arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回true；否则返回 false。
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= arr.length<= 1000
 * -1000 <= arr[i] <= 1000
 */
public class UniqueOccurrences {

//    public boolean uniqueOccurrences(int[] arr) {
//        Map<Integer, Integer> map = new HashMap();
//        for (int i : arr) {
//            //将num和出现次数保存在hash表里面
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        Set<Integer> set = new HashSet<>();
//        for (int k : map.keySet()) {
//            //然后再加入到Set中
//            set.add(map.get(k));
//            //或者直接判断集合中有没有重复的，有就返回false
////            if (set.contains(map.get(k))) return false;
//        }
//        //如果set和hash表的长度一致，那么就说明没有重复的
//        return set.size() == map.size();
//    }

    public boolean uniqueOccurrences(int[] arr) {
        int[] times = new int[2000];
        for(int i =0;i < arr.length;++i){
            times[arr[i] + 1000]++;
        }
        Set<Integer> set = new HashSet();
        for(int time : times){
            if (time == 0 ) continue;
            //没有添加成功返回false
            if(!set.add(time)) return false;

        }
        return true;
    }

}
