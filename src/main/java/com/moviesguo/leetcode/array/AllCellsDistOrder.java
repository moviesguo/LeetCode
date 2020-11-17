package com.moviesguo.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AllCellsDistOrder {

    public static void main(String[] args) {
        AllCellsDistOrder allCellsDistOrder = new AllCellsDistOrder();
        allCellsDistOrder.allCellsDistOrder(2,2,0,1);

    }

    /**
     * 广度优先排序
     * 从一点开始扩散的曼哈顿距离都是一样的
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R*C][2];
        int index = 0;
        int[][] arrive = new int[R][C];
        for(int[] an : arrive){
            Arrays.fill(an,0);
        }
        Queue<int[]> quque = new LinkedList<>();
        quque.offer(new int[]{r0,c0});
        arrive[r0][c0] = 1;
        while(!quque.isEmpty()){
            int size = quque.size();
            for(int i = 0;i < size;++i){
                int[] pos = quque.poll();
                ans[index++] = new int[]{pos[0],pos[1]};
                if(pos[0] + 1 < R && arrive[pos[0]+1][pos[1]] == 0){
                    quque.offer(new int[]{pos[0] + 1,pos[1]});
                    arrive[pos[0] + 1][pos[1]] = 1;
                }
                if(pos[0] - 1 >= 0 && arrive[pos[0]-1][pos[1]] == 0){
                    quque.offer(new int[]{pos[0] - 1,pos[1]});
                    arrive[pos[0] - 1][pos[1]] = 1;
                }
                if(pos[1] + 1 < C && arrive[pos[0]][pos[1]+1] == 0){
                    quque.offer(new int[]{pos[0],pos[1] + 1});
                    arrive[pos[0]][pos[1] + 1] = 1;
                }
                if(pos[1] - 1 >= 0 && arrive[pos[0]][pos[1]-1] == 0) {
                    quque.offer(new int[]{pos[0],pos[1] - 1});
                    arrive[pos[0]][pos[1] - 1] = 1;
                }
            }
        }
        return ans;
    }

}
