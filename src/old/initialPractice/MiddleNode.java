package javaSolutions.src.old.initialPractice;

import java.util.HashMap;
import java.util.Map;

public class MiddleNode {
    public Node middleNode(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        int size = 0;
        Node node = head;
        while (true) {
            size ++;
            map.put(size, node);
            if (node.next != null) node = node.next;
            else break;
        }
        if (size == 1) return head;
        int half = size/2;
        return map.get(half+1);
    }

    public Node middleNodeFastSlow(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
