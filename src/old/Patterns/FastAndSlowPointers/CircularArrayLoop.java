package javaSolutions.src.old.Patterns.FastAndSlowPointers;

class CircularArrayLoop {

  public static boolean loopExists(int[] arr) {
    
    for (int i = 0; i < arr.length; i++) {
      int fast = i, slow = i;

      boolean isForward = arr[i] >= 0;
      do {
        slow = nextIndex(arr, isForward, slow);
        fast = nextIndex(arr, isForward, fast);
        if (fast != -1) fast = nextIndex(arr, isForward, fast);
      } while (fast != -1 && slow != -1 && fast != slow);

      if (slow != -1 && fast == slow) return true;
    }

    return false;
  }

  static int nextIndex (int[] arr, boolean isForward, int currentIndex) {
    if (isForward != arr[currentIndex] >= 0) return -1;
    int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
    if (nextIndex < 0) nextIndex += arr.length;
    if (nextIndex == currentIndex) return -1;
    return nextIndex;
  }

  public static void main(String[] args) {
    System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
    System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
    System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
  }
}