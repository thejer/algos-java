package javaSolutions.src.old.Patterns.FastAndSlowPointers;

class RearrangeList {

  public static void reorder(ListNode head) {
    ListNode fast = head, slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode reversed = reverse(slow);
    ListNode node1 = head;
    while (node1 != null && reversed != null && node1.next != slow) {
      ListNode temp = node1.next;
      ListNode node = new ListNode(reversed.value);
      node.next = temp;
      node1.next = node;
      reversed = reversed.next;
      node1 = temp;
    }
  }

  static ListNode reverse (ListNode head) {
    ListNode prev = null;

    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);
    head.next.next.next.next.next = new ListNode(12);
    RearrangeList.reorder(head);
    while (head != null) {
      System.out.print(head.value + " ");
      head = head.next;
    }
  }
}