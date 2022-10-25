package javaSolutions.Patterns.FastAndSlowPointers;

class HappyNumber {

  public static boolean find(int num) {
    int fast = num, slow = num;

    do {
      fast = square((square(fast)));
      slow = square(slow);
    } while (slow != fast);

    return slow == 1;
  }

  public static int square(int num) {
    int sum = 0, digit;

    while (num > 0) {
      digit = num % 10;
      sum += (digit * digit);
      num /= 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(HappyNumber.find(23));
    System.out.println(HappyNumber.find(12));
  }
}