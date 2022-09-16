package javaSolutions.initialPractice;

public class ReverseString {
    public static void reverseString(char[] s) {
        int start = 0, end = s.length -1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start ++;
            end --;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        reverseString(new char[]{'H','a','n','n','a','h'});
    }
}
