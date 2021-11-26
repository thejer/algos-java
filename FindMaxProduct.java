package javaSolutions;

import java.util.*;

public class FindMaxProduct {

    static int [] findMaxProduct(int[] arr) {
        // Write your code here
       Queue<Integer> maxHeap = new PriorityQueue<>(arr.length, Comparator.reverseOrder());
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if (i <= 1) result[i] = -1;
            else {
                PriorityQueue<Integer> tempHeap = new PriorityQueue<>(maxHeap);
                result[i] = maxHeap.poll() * maxHeap.poll() * maxHeap.poll();
                maxHeap.addAll(tempHeap);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMaxProduct(new int[]{1,2,3,4,5})));
    }
}
