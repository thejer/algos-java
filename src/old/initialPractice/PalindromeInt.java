package javaSolutions.src.old.initialPractice;

public class PalindromeInt {

    static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x;
        long reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return temp == reverse;
    }

}
