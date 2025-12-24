package ds.graphs;

public class ConnectedComponents {

    private static void dfs(int node, int[][] graph, boolean[] visited) {
        visited[node] = true;
        for(int nNode : graph[node]) {
            if(!visited[nNode]) {
                dfs(nNode, graph, visited);
            }
        }
    }

    private static int countComponents(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int components = 0;

        for(int i =0; i < graph.length; i++) {
            if(!visited[i]) {
                components ++;
                dfs(i, graph, visited);
            }
        }

        return components;
    }

    public static void main(String[] args) {
        /*
            Graph:
            0 -- 1 -- 2      3 -- 4

            Components:
            {0,1,2} and {3,4}

            Answer = 2
        */

        int[][] graph = {
            {1},      // 0
            {0, 2},   // 1
            {1},      // 2
            {4},      // 3
            {3}       // 4
        };

        System.out.println(countComponents(graph)); // 2
    }
    
}