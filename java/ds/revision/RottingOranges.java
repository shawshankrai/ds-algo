package ds.revision;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    private static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 2) queue.offer(new int[] {r, c});
                if(grid[r][c] == 1) fresh++;
            }
        }

        int[][] direction = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean isRotting = false;
        int minutes = 0;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            isRotting = false;

            for(int i = 0; i < levelSize; i++) {
                int[] node = queue.poll(); 
                int r = node[0];
                int c = node[1];

                for(int[] dir : direction) {
                    int neighborR = r + dir[0];
                    int neighborC = c + dir[1];

                    if(neighborR >= 0 && neighborC >= 0 && neighborR < grid.length && neighborC < grid[0].length && grid[neighborR][neighborC] == 1){
                        grid[neighborR][neighborC] = 2;
                        isRotting = true;
                        fresh --;
                        queue.offer(new int[] {neighborR, neighborC});
                    } 
                }
            }

            if(isRotting) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        System.out.println(orangesRotting(grid));
    }
}
