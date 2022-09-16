package javaSolutions.initialPractice;

import java.util.HashMap;
import java.util.Map;

public class Encrypt {

    private static final Map<Character, Character> vowelsIntMap = new HashMap<>() {{
        put('a', '1');
        put('e', '5');
        put('i', '3');
        put('o', '2');
        put('u', '4');
    }};
    private static final Map<Character, Character> intVowelsMap = new HashMap<>() {{
        put('1', 'a');
        put('5', 'e');
        put('3', 'i');
        put('2', 'o');
        put('4', 'u');
    }};

    public static void main(String[] args) {
        System.out.println(decrypt("2rBn1mypp1H"));
        System.out.println(decrypt("HappymanBro"));
    }

    static String encrypt(String message) {
        int messageLength = message.length();

        if (messageLength < 3) return "Invalid message";

        int midPoint = messageLength / 2;

        String A = message.substring(0, midPoint);
        A = reverse(A);
        A = swapVowels(A, vowelsIntMap);
        String B = message.substring(midPoint);
        B = reverse(B);
        B = swapVowels(B, vowelsIntMap);

        return  B+A;
    }

    static String decrypt(String message) {

        int messageLength = message.length();

        if (messageLength < 3) return "Invalid message";

        int midPoint = messageLength / 2;

        int midIndex = messageLength % 2 == 0 ? midPoint : midPoint + 1;

        String B = message.substring(0, midIndex);
        B = swapVowels(B, intVowelsMap);
        B = reverse(B);

        String A = message.substring(midIndex);
        A = swapVowels(A, intVowelsMap);
        A = reverse(A);

        return A+B;
    }

    static String reverse(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    private static String swapVowels(String input, Map<Character, Character> conversionMap) {
        char[] inputChars = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char i : inputChars ) {
            Character intChar = conversionMap.get(i);
            stringBuilder.append(intChar == null ? i : intChar);
        }
        return stringBuilder.toString();
    }

}
