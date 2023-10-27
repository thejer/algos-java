package javaSolutions.src.old.initialPractice;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrences {

    private static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            if (!map.containsKey(a)){
                map.put(a, 1);
            } else {
                map.remove(a);
            }
        }
        return map.keySet().iterator().next();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,3,9,7,9,3,9}));
    }
}
