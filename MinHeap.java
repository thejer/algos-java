package javaSolutions;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private final List<Integer> heapList;
    private int currentSize;

    public MinHeap(List<Integer> array) {
        heapList = array;
        currentSize = heapList.size();
    }

    private void bubbleUp(int i) {
        int parentIdx = Math.abs(i - 1) / 2;
        while (i > 0 && heapList.get(i) < heapList.get(parentIdx)) {
            int temp = heapList.get(parentIdx);
            heapList.set(parentIdx, heapList.get(i));
            heapList.set(i, temp);
            i = parentIdx;
            parentIdx = (i - 1) / 2;
        }
    }

    public void push(int node) {
        heapList.add(node);
        currentSize++;
        int index = currentSize - 1;
        bubbleUp(index);
    }

    private void bubbleDown(int i) {
        int node = heapList.get(i);
        int leftIdx = 2 * i + 1;
        int rightIdx = 2 * i + 2;
        List<Pair<Integer, Integer>> children = getChildren(leftIdx, rightIdx);
        Pair<Integer, Integer> smaller = getSmaller(children);
        while (!children.isEmpty() && node > smaller.component1()) {
            int temp = heapList.get(i);
            heapList.set(i, heapList.get(smaller.component2()));
            heapList.set(smaller.component2(), temp);
            i = smaller.component2();
            leftIdx = 2 * i + 1;
            rightIdx = 2 * i + 2;
            children = getChildren(leftIdx, rightIdx);
            smaller = getSmaller(children);
        }

    }

    private List<Pair<Integer, Integer>> getChildren(int leftIdx, int rightIdx) {
        List<Pair<Integer, Integer>> children = new ArrayList<>();
        if (leftIdx < currentSize) children.add(new Pair<>(heapList.get(leftIdx), leftIdx));
        if (rightIdx < currentSize) children.add(new Pair<>(heapList.get(rightIdx), rightIdx));
        return children;
    }

    private Pair<Integer, Integer> getSmaller(List<Pair<Integer, Integer>> children) {
        if (children.isEmpty()) return null;
        if (children.size() == 1) return children.get(0);
        else if (children.get(0).component1() < children.get(1).component1()) return children.get(0);
        else return children.get(1);
    }

    public void pop() {
        int last = heapList.get(currentSize - 1);
        heapList.set(0, last);
        heapList.remove(currentSize - 1);
        currentSize--;
        bubbleDown(0);
    }
}
