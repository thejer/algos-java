package javaSolutions.src.old.initialPractice;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int temp = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp) {
                temp = nums[i];
                index++;
            }
            nums[index] = temp;
        }
        return index+1;
    }
}
