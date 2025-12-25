package ds.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraShortestPath {
    
    private static int shortestPath(int[][][] graph, int start, int target) {
        int[] distance = new int[graph.length];
        // Set all distance as infinity
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        pq.offer(new int[]{0, start});

        // Start traversal
        while(!pq.isEmpty()) {
            int[] state = pq.poll();
            int currentDistance = state[0];
            int currentNode = state[1];

            // check if we have less distance for node the, reject new distance
            if(currentDistance > distance[currentNode]) continue;
            // if target found return current distance
            if(target == currentNode) return currentDistance;

            // Expand neighbors with calculated distance
            for(int[] neighbor : graph[currentNode]) {
                int newNode = neighbor[0];
                int newDistance = currentDistance + neighbor[1];

                // Update neighbor's distance
                if(newDistance < distance[newNode] ) {
                    distance[newNode] = newDistance;
                    pq.offer(new int[] {newDistance, newNode});
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[][][] graph = {
            { {1,1}, {2,10} },  // 0
            { {2,1} },          // 1
            {}                  // 2
        };

        System.out.println(shortestPath(graph, 0, 2)); // 2
    }
}
