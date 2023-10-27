package javaSolutions.src.old.initialPractice;

import java.util.HashMap;
import java.util.Map;

public class AreTheyEqual {
    static   boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i=0; i < array_a.length; i++) {
            int a = array_a[i];
            int b = array_b[i];
            int counta = map.getOrDefault(a, 0);
            int countb = map2.getOrDefault(b, 0);
            map.put(a, counta+1);
            map2.put(b, countb+1);
        }

        for (int i: map.keySet()) {
            if (map.get(i) != map2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areTheyEqual(new int[]{1,2,3,4}, new int[]{1,4,3,3}));
    }
}
