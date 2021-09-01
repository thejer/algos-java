package javaSolutions;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
    public static String intToRoman(int num) {
        Map<Integer, String> intToRomanMap = new HashMap<>();
        intToRomanMap.put(1,"I");
        intToRomanMap.put(5,"V");
        intToRomanMap.put(10,"X");
        intToRomanMap.put(50,"L");
        intToRomanMap.put(100,"C");
        intToRomanMap.put(500,"D");
        intToRomanMap.put(1000,"M");

        String numString = Integer.toString(num);
        StringBuilder resultBuilder = new StringBuilder();
        while (numString.length() > 0) {
            String substring = numString.substring(0, 1);
            int firstNum = Integer.parseInt(substring);
            if (numString.length() == 4) {
                for (int i = 0; i < firstNum; i++) {
                    resultBuilder.append(intToRomanMap.get(1000));
                }
            } else if (numString.length() == 3) {

                if (firstNum == 4) {
                    resultBuilder.append("CD");
                } else if (firstNum == 9) {
                    resultBuilder.append("CM");
                } else if (firstNum < 5) {
                    for (int i = 0; i < firstNum; i++) {
                        resultBuilder.append(intToRomanMap.get(100));
                    }
                } else if (firstNum > 5) {
                    resultBuilder.append("D");
                    for (int i = 0; i < firstNum - 5; i++) {
                        resultBuilder.append(intToRomanMap.get(100));
                    }
                } else {
                    resultBuilder.append("D");
                }
            } else if (numString.length() == 2) {
                if (firstNum == 4) {
                    resultBuilder.append("XL");
                } else if (firstNum == 9) {
                    resultBuilder.append("XC");
                } else if (firstNum < 5) {
                    for (int i = 0; i < firstNum; i++) {
                        resultBuilder.append(intToRomanMap.get(10));
                    }
                } else if (firstNum > 5) {
                    resultBuilder.append("L");
                    for (int i = 0; i < firstNum - 5; i++) {
                        resultBuilder.append(intToRomanMap.get(10));
                    }
                } else {
                    resultBuilder.append("L");
                }
            } else {
                if (firstNum == 4) {
                    resultBuilder.append("IV");
                } else if (firstNum == 9) {
                    resultBuilder.append("IX");
                } else if (firstNum < 5) {
                    for (int i = 0; i < firstNum; i++) {
                        resultBuilder.append(intToRomanMap.get(1));
                    }
                } else if (firstNum > 5) {
                    resultBuilder.append("V");
                    for (int i = 0; i < firstNum - 5; i++) {
                        resultBuilder.append(intToRomanMap.get(1));
                    }
                } else {
                    resultBuilder.append("V");
                }
            }
            numString = numString.replaceFirst(substring, "");
        }
        return resultBuilder.toString();
    }

    public static String intToRoman2(int num) {
        String[] romanNums = {"I", "IV", "V", "IX", "X", "XL",
                "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] nums = {1, 4, 5, 9, 10, 40,
                50, 90, 100, 400, 500, 900, 1000};
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = nums.length -1 ; i >= 0; i--) {
            while (nums[i] <= num) {
                resultBuilder.append(romanNums[i]);
                num = num - nums[i];
            }
        }

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman2(3999));
    }
}
