package javaSolutions;

import java.util.Arrays;

public class CountSubArrays {
    static int[] countSubarrays(int[] arr) {
        // Write your code here

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            int forWin = 1;
            int backWin = 1;
            boolean forFlag = true;
            boolean backFlag = true;
            while (forFlag || backFlag) {
                int forward = i + forWin;
                int back = i - backWin;
                if (forward < arr.length && arr[forward] < arr[i]) {
                    if (forFlag) {
                        result[i] += 1;
                        forWin++;
                    }
                } else forFlag = false;

                if (back >= 0 && arr[back] < arr[i]) {
                    if (backFlag) {
                        result[i] += 1;
                        backWin++;
                    }
                } else backFlag = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSubarrays(new int[]{3, 4, 1, 6, 2})));
    }
}
