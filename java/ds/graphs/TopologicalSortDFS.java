package ds.graphs;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class TopologicalSortDFS {

    private static void dfs(int start, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[start] = true;

        for(Integer node : graph.get(start)) {
            if(!visited[node]) {
                dfs(node, graph, visited, stack);
            }
        }

        stack.push(start);
    }

    private static int[] topoSort(int numCourses, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int row = 0; row < edges.length; row++) {
            int n1 = edges[row][0];
            int n2 = edges[row][1];

            // 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
            graph.get(n1).add(n2);
        }

        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < graph.size(); i++) {
            if(!visited[i]) {
                dfs(i, graph, visited, stack);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;

        while (!stack.isEmpty()) {
            result[idx++] = stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 3}
        };

        System.out.println(Arrays.toString(topoSort(4, edges)));
        // Valid outputs: [0, 2, 1, 3] or [0, 1, 2, 3]
    }
}
