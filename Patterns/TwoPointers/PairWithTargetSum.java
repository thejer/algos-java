package javaSolutions.Patterns.TwoPointers;

class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    
    int start = 0, end = arr.length - 1;

    while (start < end) {
      int sum = arr[start] + arr[end];
      if (sum > targetSum) {
        end --;
      } else if (sum < targetSum) {
        start ++;
      } else {
        return new int[]{start, end};
      }
    }

    return new int[] { -1, -1 };
  }
}