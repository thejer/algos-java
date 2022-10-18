package javaSolutions.Patterns.TwoPointers;

class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];

    int left = 0, right = arr.length - 1, index = arr.length - 1;

    while (left < right) {
      int leftSquare = (int) Math.pow(arr[left], 2);
      int rightSquare = (int) Math.pow(arr[right], 2);

      if (rightSquare > leftSquare) {
        squares[index--] = rightSquare;
        right--;
      } else {
        squares[index--] = leftSquare;
        left ++;
      }
      
    }

    return squares;
  }
}