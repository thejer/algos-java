package javaSolutions.initialPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class GetAdditionalDinersCount {

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        // Write your code here
        ArrayList<Long> list = new ArrayList<>();
        for (long l = 1; l <= N; l++) {
            list.add(l);
        }

        for (long l : S) {
            for (long j = 0; j <= K; j++) {
                if (l + j <= N - 1)
                    list.set((int)(l + j), -1L);
                if (l - j >= 0)
                    list.set((int)(l - j), -1L);
            }
        }
        long count = 0L;

        for (long l : list) {
            if (l != -1L) {
                count++;
                for (long j = 0; j <= K; j++) {
                    if (l + j <= N - 1)
                        list.set((int)(l + j), -1L);
                }
            }
        }
        return count;
    }

    public long getMaxAdditionalDinersCount2(long N, long K, int M, long[] S) {
        // Write your code here
        Arrays.sort(S);
        long count = 0;
        long prev = 0;

        if (S[0] > K) {
            count++;
            long diff = S[0] - 1;
            count += Math.ceil((diff-K)/(K+1));
            prev = S[0];
        }

        for (long l: S) {
            long diff = l - prev;
            count += Math.max(0, Math.ceil((diff-K)/(K+1)));
            prev = l;
        }

        if (N-1 - S[S.length - 1] > K) {
            count++;
            long diff = N - 2 - S[S.length - 1];
            count += Math.ceil((diff-K)/(K+1));
        }

//        count += (N+1 - prev)/(K+1);
        return count;
    }

}

