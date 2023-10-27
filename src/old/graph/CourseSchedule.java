package javaSolutions.src.old.graph;

import java.util.*;

public class CourseSchedule {

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new LinkedList<>());
        }

        for (int[] pre : prerequisites) {
            List<Integer> preReq = preMap.get(pre[0]);
            preReq.add(pre[1]);
            preMap.put(pre[0], preReq);
            System.out.println(preMap);
        }

        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(visited, i, preMap)) return false;
        }

        return true;
    }

    static boolean dfs(boolean[] visited, int course, Map<Integer, List<Integer>> preMap) {
        if (visited[course]) return true;
        List<Integer> preReq = preMap.get(course);
        if (preReq.isEmpty()) return false;

        visited[course] = true;
        for (int pre : preReq) {
            if (dfs(visited, pre, preMap)) return true;
        }
        visited[course] = false;
        preMap.put(course, new LinkedList<>());
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
    }
}
