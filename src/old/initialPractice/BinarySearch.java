package javaSolutions.src.old.initialPractice;

public class BinarySearch {
    // Returns either the index of the location in the array,
    // or -1 if the array did not contain the targetValue
    public static int doSearch(int[] nums, int target) {

        int mid = -1, start = 0, end = nums.length-1;
        while (start <= end) {
            mid = start +  (end-start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid -1;
            else start = mid + 1;
        }
        if (nums[mid] > target) return mid;
        return mid + 1;
    }

    public static void main(String[] args) {
        System.out.println(doSearch(new int[]{1}, 0));
    }
}
