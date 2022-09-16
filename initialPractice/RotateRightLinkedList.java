package javaSolutions.initialPractice;

import java.util.ArrayList;
import java.util.List;

public class RotateRightLinkedList {
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int newi = (k+i) % (size);
            arr[newi] = list.get(i);
        }

        ListNode prevNode = null;

        for (int i = size -1; i >= 0; i--) {
            ListNode nNode = new ListNode(arr[i]);
            nNode.next = prevNode;
            prevNode = nNode;
        }

        return prevNode;
    }

    public ListNode rotateRightOptimized(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        ListNode temp = head;

        if(head == null){
            return null;
        }

        int length = 0;
        while(temp!=null){
            length++;
            temp = temp.next;
        }

        k = k%length;
        while (k-- > 0)
            first = first.next;

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = head;
        head = second.next;
        second.next = null;

        return head;
    }

    public static void main(String[] args) {

    }
}
