package javaSolutions.src.old.initialPractice;

public class TapeEquilibrium {

    private static int solution(int[] A) {
        int length = A.length;
        int[] ltr = new int[length];
        int[] rtl = new int[length];
        int min = Integer.MAX_VALUE;
        ltr[0] = A[0];
        rtl[length -1] = A[length -1];
        for (int i = 1; i < length; i++) {
            int prevIndex = i -1;
            int j = length - 1 -i;
            int nextIndex = j + 1;
            ltr[i] = ltr[prevIndex] + A[i];
            rtl[j] = rtl[nextIndex] + A[j];
        }

        for (int i = 1; i <length; i++) {
            int diff = Math.abs(ltr[i-1] - rtl[i]);
            if (diff<min) min = diff;
        }
        return min;
    }

    private static int betterSolution(int[] A) {
        // write your code in Java SE 8
        int sumOfAllNums = 0;
        for (int i = 0; i < A.length; i++) sumOfAllNums += A[i];

        int minDiff = Integer.MAX_VALUE;
        int firstPart = 0;
        int secondPart;
        for (int i=0; i < A.length-1; i++){
            firstPart += A[i];
            secondPart = sumOfAllNums - firstPart;
            minDiff = Math.min(minDiff, Math.abs(secondPart-firstPart));
        }
        return minDiff;
    }

}
