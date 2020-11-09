package com.moviesguo.leetcode.sort;

/**
 *
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 */
public class KClosest {

    public static void main(String[] args) {
        int[][] poinst = new int[10][2];
        poinst[0] = new int[]{68,97};
        poinst[1] = new int[]{34,-84};
        poinst[2] = new int[]{60,100};
        poinst[3] = new int[]{2,31};
        poinst[4] = new int[]{-27,-28};
        poinst[5] = new int[]{-73,-74};
        poinst[6] = new int[]{-55,-39};
        poinst[7] = new int[]{62,91};
        poinst[8] = new int[]{62,92};
        poinst[9] = new int[]{-57,-67};
        KClosest kClosest = new KClosest();
        int[][] ans = kClosest.kClosest(poinst, 5);
        for (int[] point : ans) {
            for (int i : point) {
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }

    public int[][] kClosest(int[][] points, int K) {

        quickSort(points,0,points.length - 1);
        int[][] ans = new int[K][2];
        for(int i = 0; i < K; ++i){
            ans[i] = points[i];
        }
        return ans;
    }

    public void quickSort(int[][] points,int start,int end){
        if(start >= end) return;
        double target = calculateDistance(points[start][0],points[start][1]);
        int left = start;
        int right = end;
        while(left != right){
            while(calculateDistance(points[right][0],points[right][1]) >= target && left < right){
                right--;
            }

            while(calculateDistance(points[left][0],points[left][1]) <= target && left < right){
                left++;
            }

            if(left < right){
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp;
            }
        }
        int[] temp = points[start];
        points[start] = points[left];
        points[left] = temp;
        quickSort(points,left + 1,end);
        quickSort(points,start,left - 1);
    }

    private double calculateDistance(int x, int y){
        return Math.sqrt(Math.pow((double)x,2) + Math.pow((double)y,2));
    }

}
