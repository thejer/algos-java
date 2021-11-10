package javaSolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.size();
        List<Integer> arr = new ArrayList<>();
        arr.isEmpty();
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
