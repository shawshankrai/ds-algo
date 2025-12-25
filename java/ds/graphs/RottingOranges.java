package ds.graphs;

import java.util.Queue;
import java.util.LinkedList;

public class RottingOranges {
    private static int orangesRotting(int [][] grid) {
        if(grid == null || grid.length == 0) return -1;

        int fresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 2) queue.offer(new int[] {r, c});
                if(grid[r][c] == 1) fresh ++; 
            }
        }

        if(fresh == 0) return 0;

        int minutes = 0;
        int[][] directions = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            boolean rottenThisMinute = false;

            for(int i = 0; i < queueSize; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                
                
                for(int[] dir: directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >=0 && nc >=0 && nr < rows && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[] {nr, nc});
                        
                        fresh--;
                        rottenThisMinute = true;
                    }
                }
            }
            
            if(rottenThisMinute) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] g1 = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println(orangesRotting(g1)); // 4

        int[][] g2 = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        System.out.println(orangesRotting(g2)); // -1

        int[][] g3 = {
            {0,2}
        };
        System.out.println(orangesRotting(g3)); // 0
    }
}
