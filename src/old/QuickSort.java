package javaSolutions.src.old;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length-1);
        return arr;
    }

    private static void quickSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = pivotPosition(arr, left, right);

            quickSortHelper(arr, left, pivot-1);
            quickSortHelper(arr, pivot + 1, right);
        }
    }

    private static int pivotPosition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j );
            }
        }
        swap(arr, ++i, right);
        return i;
    }

    private static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{3, 2, 6, 9, 0, 1})));
    }
}
