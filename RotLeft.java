package javaSolutions;

import java.util.ArrayList;
import java.util.List;

public class RotLeft {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        List<Integer> result = new ArrayList<>(a);
        int size = a.size();
        if (d == size) return a;
        if (d > size) d = d%size;
        for (int i = 0; i < size; i++) {
            int diff = i - d;
            if (diff < 0) diff = size + diff;
            Integer x = result.get(i);
            a.set(diff, x);
        }
        return a;

    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        System.out.println(rotLeft(a, 4));
    }
}
