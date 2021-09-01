package javaSolutions;

import java.util.*;

public class MaxUnits {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Map<Integer, Integer> unitsMap = new HashMap<>();
        for (int[] boxType : boxTypes) {
            int boxCount = unitsMap.getOrDefault(boxType[1], 0);
            unitsMap.put(boxType[1], boxCount + boxType[0]);
        }
        Set<Integer> unitsSet = unitsMap.keySet();
        int[] units = new int[unitsSet.size()];
        int u = 0;
        for (int unit : unitsSet) {
            units[u] = unit;
            u ++;
        }
        Arrays.sort(units);
        int count = 0;
        int remainder = truckSize;
        int i = units.length - 1;
        while (remainder > 0 && i >= 0) {
            int unit = units[i];
            int unitBoxes = unitsMap.get(unit);
            int diff = remainder - unitBoxes;
            if (diff > 0) {
                count += (unitBoxes * unit);
                remainder = diff;
            } else {
                count += (unit * remainder);
                remainder = 0;
            }
            i --;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maximumUnits(new int[][]{{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}}, 35));
    }
}
