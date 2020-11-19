package com.moviesguo.leetcode.dynamic_planning;

import java.util.*;

public class FindRotateSteps {

    public static void main(String[] args) {
        FindRotateSteps findRotateSteps = new FindRotateSteps();
        findRotateSteps.findRotateSteps("", "");
    }

    public int findRotateSteps(String ring, String key) {
        HashMap<String, Integer>[] distance = new HashMap[ring.length()];
        Queue<Integer> queue = new LinkedList<>();
        int[][] ans = new int[3][3];
        for (int[] an : ans) {
            Arrays.fill(an,0);
        }
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i);
            }
            System.out.println();
        }
        return 0;
    }

}
