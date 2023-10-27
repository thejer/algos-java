package javaSolutions.src.old.graph;

import java.util.*;

class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReq = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preReq.put(i, new ArrayList<>());
        }

        List<Integer> order = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, visited, cycle, order, preReq)) {
                return new int[0];
            }
        }
        int[] o = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            o[i] = order.get(i);
        }
        return o;
    }


    private static boolean dfs(int course, Set<Integer> visited, Set<Integer> cycle, List<Integer> order, Map<Integer, List<Integer>> preReq) {
        if (cycle.contains(course)) return true;
        if (visited.contains(course)) return false;
        cycle.add(course);
        for (int pre: preReq.get(course)) {
            if (dfs(pre, visited, cycle, order, preReq)) return true;
        }
        cycle.remove(course);
        visited.add(course);
        order.add(course);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{0, 1}})));
    }
}