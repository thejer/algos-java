package javaSolutions.src.old.Patterns.TwoPointers;

import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    int minDiff = Integer.MAX_VALUE;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length -2; i++) {
      int right = arr.length - 1, left = i+1;
      while (left < right) {
        int sum = arr[i] + arr[right] + arr[left];
        int currentDiff = targetSum - sum;

        if (currentDiff == 0) return sum;

        if (Math.abs(currentDiff) < Math.abs(minDiff) || (Math.abs(currentDiff) == Math.abs(minDiff) && currentDiff > minDiff)) 
          minDiff = currentDiff;
        if (currentDiff > 0) left++;
        if (currentDiff < 0) right--; 
      }
      
    } 

    return targetSum - minDiff;
  }
    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}