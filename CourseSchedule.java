package javaSolutions;

import java.util.*;

public class CourseSchedule {
    static Map<Integer, List<Integer>> courseToPre = new HashMap<>();
    static Set<Integer> visitedSet = new HashSet<>();

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            List<Integer> preArr = courseToPre.getOrDefault(course, new ArrayList<>());
            preArr.add(prerequisite[1]);
            courseToPre.put(course, preArr);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    public static boolean dfs(int course) {
        if (visitedSet.contains(course)) return false;
        if (courseToPre.getOrDefault(course, new ArrayList<>()).isEmpty()) return true;
        visitedSet.add(course);
        for (int pre: courseToPre.get(course)) if (!dfs(pre)) return false;
        visitedSet.remove(course);
        courseToPre.put(course, new ArrayList<>());
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(3, new int[][]{{0,2}, {2, 1}, {0, 3}, {2,3}}));
    }
}
