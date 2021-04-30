package javaSolutions;

import java.util.Arrays;

public class Reverse {

    public static void main(String[] args) {
        reverse2(-2147483648);
    }

    static int reverse(int x) {
        long xAbs = x < 0 ? x * -1L : x;
        char[] xChars = String.valueOf(xAbs).toCharArray();
        int length = xChars.length;
        int j = length-1;
        for (int i = 0; i < length/2; i++) {
            char iTemp = xChars[i];
            xChars[i] = xChars[j];
            xChars[j] = iTemp;
            j --;
        }
        long result = Long.parseLong(String.valueOf(xChars));
        if (x < 0) result *= -1;
        if (result > 2147483647 || result < -2147483648) {
            return 0;
        }
        return (int)result;
    }


    static int reverse2(int x) {
        long xAbs = x < 0 ? x * -1L : x;
        long result = 0;
        while (xAbs != 0) {
            long digit = xAbs % 10;
            result = result * 10 + digit;
            xAbs /= 10;
        }
        if (x < 0) result *= -1;
        if (result > 2147483647 || result < -2147483648) {
            return 0;
        }
        return (int)result;
    }


}
