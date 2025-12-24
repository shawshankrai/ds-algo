package ds.graphs;

import java.util.Queue;
import java.util.LinkedList;

public class GraphBFS {

    private static void bfs(int start, int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for(int node : graph[currentNode]) {
                if(!visited[node]) {
                    queue.offer(node);
                    visited[node] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
            Graph:
            0 -> {1, 2}
            1 -> {0, 3}
            2 -> {0}
            3 -> {1}

            BFS from 0:
            Output: 0 1 2 3
        */

        int[][] graph = {
            {1, 2},
            {0, 3},
            {0},
            {1}
        };

        bfs(0, graph);
    }
    
}
