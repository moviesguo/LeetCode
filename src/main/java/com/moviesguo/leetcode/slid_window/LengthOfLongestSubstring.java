package com.moviesguo.leetcode.slid_window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
        String s = "dddddd";
        System.out.println(substring.lengthOfLongestSubstring(s));
    }

    /**
     * 滑动窗口
     * 根据
     * 以 (a)bcabcbb 开始的最长字符串为 (abc)abcbb
     * 以 a(b)cabcbb 开始的最长字符串为 a(bca)bcbb
     * 以 ab(c)abcbb 开始的最长字符串为 ab(cab)cbb
     * 以 abc(a)bcbb 开始的最长字符串为 abc(abc)bb
     * 以 abca(b)cbb 开始的最长字符串为 abca(bc)bb
     * 以 abcab(c)bb 开始的最长字符串为 abcab(cb)b
     * 以 abcabc(b)b 开始的最长字符串为 abcabc(b)b
     * 以 abcabcb(b) 开始的最长字符串为 abcabcb(b)
     * 如果我们依次递增地枚举子串的起始位置，那么子串的结束位置也是递增的
     * 所以不用担心直接挪动left的时候会漏掉一些数据
     */
    public int lengthOfLongestSubstring(String s) {
        int length = 0,left = 0,right = 0;
        //map保存了某个char所在的最新位置
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char temp = s.charAt(right);
            //如果map里面有，那么就是有重复的了，再把left滑到左边的位置
            // 就是把窗口的左侧挪到了不重复的地方
            // (pw)wkew 找到了pw
            // (pww)kew 又找到一个w
            // pw(w)kew left挪到第一个w的后面一个
            if (map.containsKey(temp)) {
                left = Math.max(map.get(temp) + 1, left);
            }
            //记录其他char的位置
            map.put(s.charAt(right), right);
            //计算一下长度
            length = Math.max(length, right - left + 1);
            right++;
        }
        return length;
    }
}
