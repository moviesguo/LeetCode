package com.moviesguo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 The same repeated number may be chosen from C unlimited number of times.
 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.

 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class CombinationSum {

    public static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args){
        int[] candidates = new int[]{2,3,6,7};
        backTracking(new ArrayList<>(), candidates, 0, 7);
        for (List<Integer> list : ans) {
            System.out.println(list.toString());
        }

    }

    /*
    回溯的思路，不断的进入下一层，每一层都要来一遍，当然判断条件第二个限制了一下，节省了一些时间。
    不断的去用target剪掉当前数再去找，知道target=0的时候加入到list里面，当找完结束后要将加入的元素移除；
     */

    public static void backTracking(List<Integer> cur, int[] candidates,int from, int target){
        if (target == 0) {
            List<Integer> list = new ArrayList<Integer>(cur);
            ans.add(list);
        } else {
            for (int i = from; i < candidates.length && candidates[i] <= target; i++) {
                cur.add(candidates[i]);
                backTracking(cur, candidates, i, target - candidates[i]);
                cur.remove(cur.size()-1);
            }
        }

    }

}
