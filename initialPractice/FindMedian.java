package javaSolutions.initialPractice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedian {
    static boolean isEven(int n) {
        return n%2 == 0;
    }

    static int getMed(int[] arr, int n) {
        if (isEven(n)) {
            return (arr[n/2] + arr[(n/2) - 1])/2;
        } else {
            return arr[n/2];
        }
    }

    static int[] findMedian(int[] arr) {
        // Write your code here
        Queue<Integer> minHeap = new PriorityQueue<>();
        int size = arr.length;
        int[] output = new int[size];
        for (int i: arr) {
            minHeap.add(i);
        }

        int[] medArr = new int[size];
        for (int i = 0; i < size; i++) {
            int min = minHeap.poll();
            medArr[i] = min;
            System.out.println(Arrays.toString(medArr));
            int med = getMed(medArr, i + 1);
            System.out.println(med);
            output[i] = med;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMedian(new int[]{5, 15, 1, 3})));
    }
}
