package com.moviesguo.leetcode.dynamic_planning;

import java.util.Arrays;

/**
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为T秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段clips[i]都用区间进行表示：开始于clips[i][0]并于clips[i][1]结束。我们甚至可以对这些片段自由地再剪辑，例如片段[0, 7]可以剪切成[0, 1] +[1, 3] + [3, 7]三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回-1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 * 示例 2：
 *
 * 输入：clips = [[0,1],[1,2]], T = 5
 * 输出：-1
 * 解释：
 * 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 * 示例 3：
 *
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 * 输出：3
 * 解释：
 * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 * 示例 4：
 *
 * 输入：clips = [[0,4],[2,8]], T = 5
 * 输出：2
 * 解释：
 * 注意，你可能录制超过比赛结束时间的视频。
 *
 *
 * 提示：
 *
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <=clips[i][1] <= 100
 * 0 <= T <= 100
 *
 */
public class VideoStitching {

    public static void main(String[] args) {
        VideoStitching videoStitching = new VideoStitching();
//        int[][] clips = {{0,2}, {4,6}, {8,10}, {1,9}, {1,5}, {5,9} };
//        int[][] clips = {{0,1},{1,2} };
//        int[][] clips = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3}
//                ,{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        int[][] clips = {{0,6},{6,9}};
        System.out.println(videoStitching.videoStitching(clips, 9));
    }
//    public int videoStitching(int[][] clips, int T) {
//        int[] dp = new int[T+1];
//        dp[0] = 0;
//        int size = clips.length;
//        for(int i = 1;i <= T;i++){
//            dp[i] = T + 1;
//            for(int j = 0;j < size;j++){
//                int down = clips[j][0];
//                int up = clips[j][1];
//                if(down <=i && up>=i){
//                    //其实不用这样，直接按下面的思路来
//                    //如果当前区间是从0开始的，那么最小数目就是1
//                    if(down == 0) dp[i] = 1;
//                        //如果不是从0开始的就要看前面的最小值
//                    else {
//                        //遍历去前面找合适的
//                        for(int k = i - 1;k >= down;k--){
//                            if (dp[k] == T + 1){ continue;}
//                            dp[i] = Math.min(dp[k] + 1,dp[i]);
//                        }
//                    }
//                }
//            }
//        }
//        return dp[T] == T+1 ? -1 : dp[T];
//    }

    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        //找i的每个值的最小值
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                //如果这里这个片段的起始段小于当前的，并且尾部大于等于当前的，就可以认为是有效的拼接
                //然后直接去找这个片段头部的最小的点就可以了
                if (clip[0] < i && i <= clip[1]) {
                    //如果clip为[0,8] 那么就是 dp[0] + 1
                    //如果clip为[1,9] 那么就是 dp[1] + 1 ,所以不需要把 i 到 clip[i] 之间的数都找一遍
                    // [6,9],[1,6],[0,6]
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

}
