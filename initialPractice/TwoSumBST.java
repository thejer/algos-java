package javaSolutions.initialPractice;

public class TwoSumBST {
    public static boolean findTarget() {
        int n = 1/2;
        System.out.println(n);
     return false;
    }

    public boolean find(TreeNode root, int k) {
        if (root.val == k) return true;
        else if (root.val > k && root.left != null)
            return find(root.left, k);
        else if (root.val < k && root.right != null) return find(root.right, k);
        else return false;
    }

    public static void main(String[] args) {
//        bSearch(new int[]{-1,0,3,5,9,12}, 0, 5, 9);
        findTarget();
    }

    public static int bSearch(int[] nums, int start, int end, int target) {
        int half = (start + end)/2;

        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("half: " + half);
        int pos = nums[half];
        System.out.println("pos: " + pos);

        if (start == end) return -1;
        if (pos == target) return half;
        else if (pos > target) return bSearch(nums, start, half -1, target);
        else return bSearch(nums, half + 1, end, target);
    }
}
