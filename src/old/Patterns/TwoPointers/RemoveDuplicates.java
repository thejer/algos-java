package javaSolutions.src.old.Patterns.TwoPointers;

import java.util.Arrays;

class RemoveDuplicates {

  public static int remove(int[] arr) {
    int uniqueCount = 1;
    if (arr.length == 0) return 0;
    int current = arr[0];
    for (int n: arr) {
      if (n != current) {
        uniqueCount++;
        current = n;
      }
    }
    return uniqueCount;
  }

  public static int removeDuplicate(int[] arr) {
    int left = 0;
    for (int right = 0; right < arr.length; right ++) {
      int leftNum = arr[left], rightNum = arr[right];
      if (leftNum != rightNum) {
        arr[++left] = rightNum;
      }
    }
    System.out.println(Arrays.toString(arr));
    return left+1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
    System.out.println(removeDuplicate(arr));

    arr = new int[] { 2, 2, 2, 11 };
    System.out.println(removeDuplicate(arr));
  }
}