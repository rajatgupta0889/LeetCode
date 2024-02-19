package org.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static class Queues {
           QueueItem queueItem;
           int depth;

           public Queues(int i, int j, int depth) {
               this.queueItem = new QueueItem(i,j);
               this.depth= depth;
           }
    }

    public static class QueueItem{
        int i;
        int j;

        public QueueItem(int i, int j) {
            this.i = i;
            this.j =j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Queues> queue = new LinkedList<>();
        int[][] visitedGrid = new int[n][m];
        int freshCount = 0;
        for(int i=0; i<n; i++){
            for(int j =0; j < m; j++){
                if(grid[i][j] == 2){
                    queue.add(new Queues(i,j,0));
                    visitedGrid[i][j] =2;
                }else{
                    visitedGrid[i][j] =0;
                }

                if(grid[i][j] == 1) freshCount++;
            }
        }

        int time = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count =0;
        while (!queue.isEmpty()){
            Queues queues = queue.poll();
            int row = queues.queueItem.i;
            int col = queues.queueItem.j;
            int depth = queues.depth;
            time = Math.max(depth,time);
            for(int i = 0; i <4; i++) {
                int x = row + dx[i];
                int y = col + dy[i];
                if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0 ||
                        visitedGrid[x][y] == 2) continue;

                visitedGrid[x][y] = 2;
                count++;
                queue.offer(new Queues(x,y,depth+1));
            }
        }
        if(count != freshCount)
            return -1;
        return time;

    }


    public static void main(String[] args) {
        int[][] grid ={{2,1,1},{1,1,0},{0,1,1}};

        RottenOranges rottenOranges = new RottenOranges();
        System.out.println(rottenOranges.orangesRotting(grid));
    }
}
