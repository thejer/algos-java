package javaSolutions.initialPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxCandies {
    static int maxCandies(int[] arr, int k) {
        // Write your code here
        Queue<Integer> maxHeap = new PriorityQueue<>(arr.length, Comparator.reverseOrder());
        maxHeap.addAll(Arrays.stream(arr).boxed().toList());
        int total = 0;
        while (k > 0){
            int max = maxHeap.poll();
            total += max;
            maxHeap.add((int)max/2);
            k--;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] arr_1 = {2, 1, 7, 4, 2};
        int[] arr_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        System.out.println(maxCandies(arr_2, 3));
    }
}
