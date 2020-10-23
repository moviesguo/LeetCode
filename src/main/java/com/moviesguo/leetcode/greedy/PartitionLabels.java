package com.moviesguo.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        partitionLabels("ababcbacadefegdehijhklij");
    }

    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        //找到每个字母最后到的位置
        for(int i = 0;i < length;i++){
            last[s.charAt(i)-'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0,end = 0;
        //求最短的长度可能就是包含了更少的字母
        for(int i = 0; i < s.length(); i++){
            // 记录一下前面这些字符出现的最后的位置，
            /**
             * 对于每个访问到的字母 c，得到当前字母的最后一次出现的下标位置 endC
             *  ，则当前片段的结束下标一定不会小于 endC
             *  ，因此令 end = max(end,endC)
             */
            end = Math.max(end, last[s.charAt(i) - 'a']);
            //如果到了前面字符共有的最大的那个位置，就是能划分的最小串了
            if (i == end) {
                //记录数量
                partition.add(end - start + 1);
                //然后更新起始位置
                start = end + 1;
            }
        }
        return partition;
    }

}
