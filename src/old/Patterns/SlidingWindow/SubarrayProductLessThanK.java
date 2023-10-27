package javaSolutions.src.old.Patterns.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < target) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(arr[i]);
                subarrays.add(tempList);
                int prod = arr[i];
                if (i == arr.length - 1) break;
                int j = i + 1;
                while (prod < target && j < arr.length) {
                    prod *= arr[j];
                    if (prod < target) {
                        List<Integer> sublist = new ArrayList<>(subarrays.get(subarrays.size() - 1));
                        sublist.add(arr[j++]);
                        subarrays.add(new ArrayList<>(sublist));
                    }
                }
            }
        }

        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[]{8, 2, 6, 5}, 50));// [8], [8,2], [2], [2,6], [6], [6,5], [5]
    }
}