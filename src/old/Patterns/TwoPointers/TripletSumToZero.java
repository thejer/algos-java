package javaSolutions.src.old.Patterns.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> triplets = new ArrayList<>();
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 2; i++) {
      if (i > 0 && arr[i] == arr[i-1]){
        continue;
      }
      findPair(arr, i + 1, -arr[i], triplets);
    }

    return triplets;
  }

  private static void findPair(int[] arr, int left, int target, List<List<Integer>> triplets) {
    int right = arr.length - 1;
    while (left < right) {
      int sum = arr[right] + arr[left];
      if (sum == target) {
        triplets.add(Arrays.asList(-target, arr[left++], arr[right--]));
        while (left < right && arr[left] == arr[left-1]){
            left ++;
        }
        while (left < right && arr[right] == arr[right + 1]) {
          right --;
        }
      } else if (target < sum) {
        right --;
      } else {
        left ++;
      }
    }
  }
}