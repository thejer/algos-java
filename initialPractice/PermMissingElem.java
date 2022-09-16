package javaSolutions.initialPractice;

public class PermMissingElem {
    private static int solution(int[] A) {
        int N = A.length + 1;
        if (N == 1) return 1;
        int sum = 0;
        int numSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            numSum += (i + 1);
        }
        return (numSum + N) - sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,1,5}));
    }
}
