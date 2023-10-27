package javaSolutions.src.old.Patterns.FastAndSlowPointers;

class LinkedListCycleStart {

  public static ListNode findCycleStart(ListNode head) {
    ListNode fast = head, slow = head;
    int cycleLength = 0;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return getCycleStart(head, findLength(slow));
      }
    }
    return head;
  }

  public static int findLength(ListNode node) {
    ListNode current = node;
    int size = 0;

    do {
      current = current.next;
      size++;
    } while (current != node);

    return size;
  }

  public static ListNode getCycleStart(ListNode head, int size) {
    ListNode left = head, right = head;

    while (size != 0) {
      right = right.next;
      size--;
    }
    
    while (left != right) {
      left = left.next;
      right = right.next;
    }
    return left;
  }


  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
  }
}