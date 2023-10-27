package javaSolutions.src.old.initialPractice;

class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0, left = 0, right = 0;
        int end = nums.length -1;
        while (right < end) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            left = right + 1;
            right = farthest;
            jumps ++;
        }
        return jumps;
    }
}