package javaSolutions.initialPractice;

public class RemoveNthFromTheEnd {
    public Node removeNthFromEnd(Node head, int n) {
        int index = 1;
        Node node = head;
        while (node.next != null) {
            index++;
            node = node.next;
        }
        int [] nodeValues = new int[index];
        index = 0;
        node = head;
        do {
            nodeValues[index] = node.val;
            node = node.next;
            index++;
        } while (node != null);

        int indexToBeRemoved = nodeValues.length - n;
        node = null;
        for (int i = nodeValues.length -1 ; i >= 0; i--) {
            if (i != indexToBeRemoved) {
                Node currentNode = new Node(nodeValues[i]);
                currentNode.next = node;
                node = currentNode;
            }
        }
        return node;
    }

    public Node removeNthFromEndOptimized(Node head, int n) {
        Node left = head;
        Node right = head;

        while (n -- > 0) {
            right = right.next;
        }
        if (right == null) return head.next;

        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return head;
    }
}
