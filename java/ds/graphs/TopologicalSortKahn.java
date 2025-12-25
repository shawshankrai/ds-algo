package ds.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortKahn {
    private static int[] topoSort(int[][] graph) {
        int n = graph.length;

        // Calculate inIndex
        int[] inIndex = new int[graph.length];
        for(int u = 0; u < n; u++) {
            for(int v : graph[u]) {
                inIndex[v]++;
            }
        }

        // Add node with no dependency to queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inIndex.length; i++) {
            if(inIndex[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[n];
        int idx = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result[idx++] = u;

            for(int v : graph[u]) {
                inIndex[v]--;
                // inDegree already enforces single entry, no visited required
                if(inIndex[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return n == idx ? result : new int[0];

    }
    public static void main(String[] args) {
        int[][] dag = {
            {1, 2},  // 0
            {3},     // 1
            {3},     // 2
            {}       // 3
        };

        System.out.println(Arrays.toString(topoSort(dag)));
    }
}
