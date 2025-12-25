package ds.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnweighted {
    private static int shortestPath(int[][] graph, int start, int target) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        int distance = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++) {
                int node = queue.poll();
                
                if(node == target) return distance;

                for(int neighbor : graph[node]) {
                    if(!visited[neighbor])  {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }

            distance++;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2},
            {3},
            {3},
            {}
        };

        System.out.println(shortestPath(graph, 0, 3)); // 2
    }
}
