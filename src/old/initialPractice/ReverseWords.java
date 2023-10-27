package javaSolutions.src.old.initialPractice;

public class ReverseWords {
    public static String reverseWords(String s) {
        String [] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            result.append(reverseString(word.toCharArray()));
            if (i < words.length -1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    private static String reverseString(char[] s) {
        System.out.println(s);
        int start = 0, end = s.length -1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start ++;
            end --;
        }
        return String.valueOf(s);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
