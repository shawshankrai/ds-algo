package ds.graphs;

public class CycleDetectionUndirected {

    private static boolean dfs(int node, int parent, int[][] graph, boolean[] visited) {
        visited[node] = true;

        for(int nNode : graph[node]) {
            if(!visited[nNode]) {
                if(dfs(nNode, node, graph, visited)) {
                    return true;
                }
            } else if (nNode != parent) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasCycle(int[][] graph) {
        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                if(dfs(i , -1, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        // Graph with cycle
        int[][] g1 = {
            {1, 2},
            {0, 2},
            {0, 1}
        };
        System.out.println(hasCycle(g1)); // true

        // Graph without cycle
        int[][] g2 = {
            {1},
            {0, 2},
            {1, 3},
            {2}
        };
        System.out.println(hasCycle(g2)); // false
    }
}
