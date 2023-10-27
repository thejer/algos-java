package javaSolutions.src.old.initialPractice;

public class Factorial {

    public static int factorial(int n) {
        int result = 1;

        // Implement this method
        if (n > 1) {
            result = factorial(n - 1) * n;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(factorial(0));
    }

}
