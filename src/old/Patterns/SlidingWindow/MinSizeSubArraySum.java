package javaSolutions.src.old.Patterns.SlidingWindow;

class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int minimum = Integer.MAX_VALUE, start = 0, end = 0, sum = 0;
    // [2, 1, 5, 2, 3, 2] 7
    while (true) {
      if (sum >= S) {
        int size = end - start; // 3
        minimum = Math.min(minimum, size); // 3
        sum -= arr[start]; //
        start ++;
      } else {
        if (end == arr.length) break;
        sum += arr[end]; // 8
        end ++; // 3
      }
    }
    return minimum;
  }
}