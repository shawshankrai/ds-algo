package ds.graphs;

public class NumberOfIslandsDFS {

    private static int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                // if not visited
                if(grid[r][c] == '1') {
                    islands++;
                    dfs(r, c, grid);
                }
            }
        }

        return islands;
    }

    private static void dfs(int r, int c, char[][] grid) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;

        // if not visited
        if(grid[r][c] == '1') {
            // mark visited
            grid[r][c] = '0';

            dfs(r - 1, c, grid);
            dfs(r + 1, c, grid);
            dfs(r , c - 1, grid);
            dfs(r , c + 1, grid);
        }
    }
    public static void main(String[] args) {
        char[][] grid1 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid1)); // 3

        char[][] grid2 = {
            {'1','0','1'},
            {'0','0','0'},
            {'1','0','1'}
        };
        System.out.println(numIslands(grid2)); // 4
    }
}
