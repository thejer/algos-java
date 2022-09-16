package javaSolutions.initialPractice;

import java.util.*;

public class FindSignatureCount {

    static int[] findSignatureCounts(int[] arr) {
        // Write your code here
        List<Set<Integer>> setList = new ArrayList<>();
        for (int num : arr) {
            if (setList.isEmpty()) {
                Set<Integer> set = new HashSet<>();
                set.add(num);
                set.add(arr[num - 1]);
                setList.add(set);
            } else {
                boolean found = false;
                for (int j = 0; j < setList.size(); j++) {
                    Set<Integer> set = setList.get(j);
                    System.out.println(set);
                    System.out.println("num: " + num);
                    if (set.contains(num)) {
                        found = true;
                        System.out.println("found");
                        set.add(arr[num - 1]);
                        setList.set(j, set);
                    }
                }
                if (!found) {
                    System.out.println("not found");
                    Set<Integer> set = new HashSet<>();
                    set.add(num);
                    set.add(arr[num - 1]);
                    setList.add(set);
                }
            }
        }
        System.out.println(setList);
        int[] result = new int[arr.length];
        for (int i: arr) {
            for (Set<Integer> set: setList) {
                if (set.contains(i)) {
                    result[i-1] = set.size();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSignatureCounts(new int[]{1,2})));
    }
}
