package javaSolutions.initialPractice;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWays {

    static int numberOfWays(int[] arr, int k) {
        // Write your code here
        int result = 0;
        Map<Integer,Integer> numCount = new HashMap<>();
        for (int i: arr) {
            int val = numCount.getOrDefault(i, 0);
            numCount.put(i, val+1);
        }


        for (int i: arr) {
            int val = numCount.get(i);
            numCount.put(i, val-1);
            int diff = k - i;
            int diffVal = numCount.getOrDefault(diff, 0);
            if (diffVal > 0) {
                result+=diffVal;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(new int[]{3,3,3,3,3,3,3,}, 6));
    }
}
