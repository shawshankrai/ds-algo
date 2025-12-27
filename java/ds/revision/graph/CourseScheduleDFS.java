package ds.revision.graph;

import java.util.List;
import java.util.ArrayList;

public class CourseScheduleDFS {
    private static boolean dfs(int start, List<List<Integer>> graph, boolean[] visited, boolean[] inStack) {
        visited[start] = true;
        inStack[start] = true;

        for(int v : graph.get(start)) {
            if(!visited[v]) {
                if(dfs(v, graph, visited, inStack)) {
                    return true;
                }
            } else if(inStack[v]) {
                return true;
            }
        }

        inStack[start] = false;

        // no cycle for current iteration
        return false;
    }
    private static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        for(int u = 0; u < graph.size(); u++) {
            if(!visited[u]) {
                if(dfs(u, graph, visited, inStack)) {
                    return false;
                }
            }
        }

        // If no cycle then finish the course
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        // {course, prerequisite}
        int[][] prerequisites = new int [][] {{1, 0}};

        System.out.println(canFinishDFS(numCourses, prerequisites));

        numCourses = 2;
        prerequisites = new int [][] {{1, 0}, {0, 1}};
        System.out.println(canFinishDFS(numCourses, prerequisites));

        numCourses = 4;
        prerequisites = new int [][] {{1,0}, {2,1}, {3,2}};
        System.out.println(canFinishDFS(numCourses, prerequisites));
    }
}
