package javaSolutions;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        check(new String[]{"9","0","8", "8","8","3","2"});
    }

    public static void check(String [] arr) {
        int currentLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                if (Objects.equals(arr[i], arr[i - 1])) {
                    currentLen++;
                    if (currentLen >= 3) {
                        System.out.println("yes");
                        break;
                    }
                } else {
                    currentLen = 0;
                    currentLen++;
                }
            } else {
                currentLen ++;
            }
        }
    }
}
