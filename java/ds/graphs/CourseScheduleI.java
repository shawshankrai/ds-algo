package ds.graphs;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseScheduleI {

    private static boolean canFinish(int num, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[graph.size()];
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int idx = 0;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            idx++;

            for(int v : graph.get(u)) {
                inDegree[v]--;
                if(inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return idx == graph.size() ? true : false;
    }
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}})); // true
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}})); // false
    }
}
