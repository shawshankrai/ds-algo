package ds.graphs;

public class GraphDFS {
    private static void dfs(int node, int[][] graph, boolean[] visited) {
        if(visited[node]) return;

        visited[node] = true;

        System.out.println(node + " ");

        for(int neighbor: graph[node]) {
            dfs(neighbor, graph, visited);
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2},
            {0, 3},
            {0},
            {1}
        };

        boolean[] visited = new boolean[graph.length];

        dfs(0, graph, visited);
    }
}
