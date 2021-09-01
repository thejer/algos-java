package javaSolutions;


import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static Node copyRandomList(Node head) {
        if (head == null) return head;
        int[] listVals = traverseLL(head);
        Node[] nodeList = new Node[listVals.length];
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        int length = listVals.length;
        Node prevNode = null;
        Node currentNode = null;
        Node node = head;
        int index = 0;
        while (true) {
            nodeToIndex.put(node, index);
            index ++;
            if (node.next == null) break;
            else node = node.next;
        }

        for (int i = length - 1; i >= 0; i--) {
            currentNode = new Node(listVals[i]);
            nodeList[i] = currentNode;
            currentNode.next = prevNode;
            prevNode = currentNode;
        }

        node = head;
        Node tempNode = currentNode;
        while (true) {
            if (node.random == null)
                tempNode.random = null;
            else
                tempNode.random = nodeList[nodeToIndex.get(node.random)];
            if (node.next == null) break;
            else {
                node = node.next;
                tempNode = tempNode.next;
            }
        }

        return  currentNode;
    }

    public static int[] traverseLL(Node head) {
        int count = getLLDepth(head);
        Node node = head;
        int[] llVals = new int[count];
        int i = 0;
        while (true) {
            llVals[i] = node.val;
            i ++;
            if (node.next == null) break;
            else {
                node = node.next;
            }
        }
        return llVals;
    }

    public static void printLL(Node head) {
        Node node = head;
        while (true) {
            System.out.print(node.val + " ");
            if (node.random == null) System.out.print("[null] ");
            else
                System.out.print("[" + node.random.val + "] ");
            if (node.next == null) break;
            else node = node.next;
        }
    }

    private static int getLLDepth(Node head) {
        Node node = head;
        int count = 0;
        while (true) {
            count ++;
            if (node.next == null) break;
            else node = node.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node h = new Node(7);
        h.next = new Node(13);
        h.next.next = new Node(11);
        h.next.next.next = new Node(10);
        h.next.next.next.next = new Node (1);
        h.next.random = h;
        h.next.next.random = h.next.next.next.next;
        h.next.next.next.random = h.next.next;
        h.next.next.next.next.random = h;

//        printLL(h);
        printLL(copyRandomList(h));
    }
}
