package javaSolutions.src.old.initialPractice;

import java.util.Arrays;

public class TwoSumSorted {
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length-1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum < target) start++;
            else if (sum > target) end --;
            else return new int[]{start + 1, end + 1};
        }
        return new int [] {0,0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }
}
