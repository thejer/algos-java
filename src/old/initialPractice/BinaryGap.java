package javaSolutions.src.old.initialPractice;

import java.util.Scanner;

public class BinaryGap {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Number: ");
        int number = scanner.nextInt();
        System.out.println(getBinaryGap(number));
    }
    private static int getBinaryGap(int number) {
        int max_val = Integer.MIN_VALUE;
        String binNumber = intToBin(number);
        int value = 0;
        char[] bins = binNumber.toCharArray();
        for (char binChar : bins) {
            if (binChar == '0') value+=1;
            else if (binChar == '1' && value > max_val){
                max_val = value;
                value = 0;
            } else {
                value = 0;
            }
        }
        return max_val;
    }

    private static String intToBin(int integer) {
        if (integer == 0) return "O";
        StringBuilder bin = new StringBuilder();
        while (integer > 0) {
            String digit = ((integer & 1) == 1) ? "1" : "0";
            bin.insert(0, digit);
            integer = Math.floorDiv(integer, 2);
        }
        return bin.toString();
    }
}
