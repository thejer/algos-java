package javaSolutions;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numberToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            numberToIndex.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numberToIndex.containsKey(diff)) {
                result[0] = i;
                result[1] = numberToIndex.get(diff);
                break;
            }
        }
        return result;
    }
}
