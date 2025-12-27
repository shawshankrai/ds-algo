package ds.revision.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleI {

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int r = 0; r < numCourses; r++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses]; 
        for(int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];

            inDegree[course]++;
            graph.get(pre).add(course);   
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            result[idx++] = u;

            for(int v : graph.get(u)) {
                inDegree[v]--;
                if(inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return idx == numCourses;
    }
    public static void main(String[] args) {
        int numCourses = 2;
        // {course, prerequisite}
        int[][] prerequisites = new int [][] {{1, 0}};

        System.out.println(canFinish(numCourses, prerequisites));

        numCourses = 2;
        prerequisites = new int [][] {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses, prerequisites));

        numCourses = 4;
        prerequisites = new int [][] {{1,0}, {2,1}, {3,2}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
