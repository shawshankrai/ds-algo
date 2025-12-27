package ds.revision.graph;

// connected components
public class IslandDFS {
    private static void dfs(int r, int c, char[][] graph) {
        if(r < 0 || c < 0 || r >= graph.length || c >= graph[0].length) return;

        if(graph[r][c] == '0') return;

        graph[r][c] = '0';

        dfs(r - 1, c, graph);
        dfs(r + 1, c, graph);
        dfs(r, c - 1, graph);
        dfs(r, c + 1, graph);
    }
    private static int numberOfIslands(char[][] graph) {
        int island = 0;
            for(int r = 0; r < graph.length; r++) {
                for(int c = 0; c < graph[0].length; c++) {
                    if(graph[r][c] == '1') {
                        island++;
                        dfs(r, c, graph);
                    }
                }
            }
        return island;
    }
    public static void main(String[] args) {
        char[][] input = new char[][] {
            {'1','1','0','0'},
            {'1','1','0','0'},
            {'0','0','1','0'},
            {'0','0','0','1'}
        };

        System.out.println(numberOfIslands(input)); // 3
    }
}
