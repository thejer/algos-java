package javaSolutions.src.old.initialPractice;

import java.util.Arrays;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int availableIndex = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[availableIndex] = num;
                availableIndex++;
            }
        }
        while (availableIndex < nums.length) {
            nums[availableIndex] = 0;
            availableIndex++;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
