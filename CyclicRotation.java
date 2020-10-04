package javaSolutions;

public class CyclicRotation {

    private static int[] solution(int[] A, int K) {
        int[] newA = A.clone();
        int N = newA.length;
        if (N == 0) return A;
        if (K > N) K = K % N;
        if (K == N) return A;
        for (int i = 0; i < N; i++) {
            int newIndex = -1 - ((N-1) - (i + K));
            if (newIndex < 0) newIndex += N;
            newA[newIndex] = A[i];
        }
        return newA;
    }

}
