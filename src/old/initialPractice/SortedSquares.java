package javaSolutions.src.old.initialPractice;

import java.util.Arrays;

public class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = num * num;
        }
        int n = nums.length;
        int[] newNums = new int[n];
        int i = 0, j = n - 1, k = n-1;
        while (j > i) {
            if (nums[j] > nums [i]) {
                newNums [k] = nums[j];
                j --;
                k --;
            } else if (nums[j] < nums[i]) {
                newNums [k] = nums[i];
                k --;
                i ++;
            } else {
                newNums[k] = nums[i];
                k --;
                newNums[k] = nums[j];
                i++;
                j--;
                k--;
            }
        }
        if (k >= 0)
            newNums[k] = nums[i];
        return newNums;
    }
    public int[] sortedSquares2(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        int[] newNums = new int[n];
        int left = 0, right = n - 1;
        for (int i = n-1; i >= 0; i --) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else{
                square = nums[left];
                left++;
            }
            newNums[i] = square * square;
        }
        return newNums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-10000,-9999,-7,-5,0,0,10000})));
    }
}
