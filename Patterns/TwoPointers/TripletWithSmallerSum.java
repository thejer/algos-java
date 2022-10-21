package javaSolutions.Patterns.TwoPointers;

import java.util.*;

class TripletWithSmallerSum {

  public static int searchTriplets(int[] arr, int target) {
    int count = 0;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 2; i++) {
      int targetSum = target - arr[i], left = i + 1, right = arr.length - 1;
      while (left < right) {
        int sum = arr[left] + arr[right];
        if (targetSum > sum) {
          count += right - left;
          left++;
        } else {
          right --;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
    System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
  }
}