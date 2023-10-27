package javaSolutions.src.old.initialPractice;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        String longestPal = "";
        s = s.strip();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            longestPal = getLongestPal(s, longestPal, sChar, i, i);
            longestPal = getLongestPal(s, longestPal, sChar, i, i +1);
        }
        return longestPal;
    }

    private static String getLongestPal(String s, String longestPal, char[] sChar, int c, int j) {
        while (c >= 0 && j < sChar.length && sChar[c] == sChar[j]) {
            String pal = s.substring(c, j + 1);
            if (longestPal.length() < pal.length())
                longestPal = pal;
            c--;
            j++;
        }
        return longestPal;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbcd"));
    }
}
