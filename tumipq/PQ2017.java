package javaSolutions.tumipq;

class PQ2017 {

    public static void main(String[] args) {
        int n = 5;
        int r = 3;
        long nCr = nFactorial(n) / (nFactorial(n-r) * nFactorial(r));
        System.out.println(nFactorial(-5));
    }

    static long nFactorial (int n) {
        int total = 1;
        int newn = Math.abs(n);
        for (int i = newn; i  >= 2 ; i--) {
            total *= i;
        }
        if (n < 0) return -total;
        return total;
    }

}
