package javaSolutions.src.old.Patterns.TwoPointers;

class DutchFlag {

    public static void sort(int[] arr) {

        int i = 0, k = 0, j = arr.length - 1;

        while (k <= j) {
            int num = arr[k];
            if (num == 0) {
                int temp = arr[i];
                arr[i++] = 0;
                arr[k++] = temp;

            } else if (num == 2) {
                int temp = arr[j];
                arr[k] = temp;
                arr[j--] = 2;
            } else if (num == 1) {
                k++;
            }
        }

    }
}