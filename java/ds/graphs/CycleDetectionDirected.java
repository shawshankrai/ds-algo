package ds.graphs;

public class CycleDetectionDirected {
    
    private static boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] inStack) {
        visited[node] = true;
        inStack[node] = true;

        for(int neighbor : graph[node]) {
            if(!visited[neighbor]) {
                if(dfs(neighbor, graph, visited, inStack)) {
                    return true;
                }
            } else if (inStack[neighbor]) {
                return true;
            }
        }
        inStack[node] = false;
        return false;
    }

    private static boolean hasCycle(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                if(dfs(i, graph, visited, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Graph with cycle: 0 → 1 → 2 → 0
        int[][] g1 = {
            {1},
            {2},
            {0}
        };
        System.out.println(hasCycle(g1)); // true

        // Graph without cycle: 0 → 1 → 2
        int[][] g2 = {
            {1},
            {2},
            {}
        };
        System.out.println(hasCycle(g2)); // false
    }
}
