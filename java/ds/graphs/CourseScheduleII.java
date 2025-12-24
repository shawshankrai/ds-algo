package ds.graphs;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CourseScheduleII {

    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        int[] inDegree = new int[numCourses]; 
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while(!queue.isEmpty()) {
            int u = queue.poll();
            order[idx++] = u;

            for(int v : graph.get(u)) {
                inDegree[v]--;
                if(inDegree[v] == 0) queue.offer(v);
            }
        }

        return numCourses == idx ? order : new int[0];
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
        // One valid output: [0, 1]

        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}, {0, 1}})));
        // Output: [] (cycle)

        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
        // One valid output: [0, 1, 2, 3] (or [0, 2, 1, 3])
    }
}
