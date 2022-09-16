package javaSolutions.initialPractice;

import java.util.Scanner;

public class PerfectSquare {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int l = Integer.parseInt(dimensions[0]);
            int w = Integer.parseInt(dimensions[1]);
            System.out.println(getPerfectSquares(l, w));
        }
    }

    public static int getPerfectSquares(int l, int w) {
        int count = 0;
        int limit = Math.min(l, w);
        for (int i = 1; i <= limit; i++) {
            int square = (l - i + 1) * (w - i + 1);
            count += square;
        }
        return count;
    }

}
