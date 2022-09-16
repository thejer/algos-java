package javaSolutions.initialPractice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        
        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        
        for (ListNode list: lists) {
            if (list != null)
                minHeap.add(list);
        }
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = new ListNode(node.val);
            current = current.next;
            node = node.next;
            if (node != null)
                minHeap.add(node);
        }
        return head.next;
    }
}