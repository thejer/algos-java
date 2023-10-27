package javaSolutions.src.old.Patterns.FastAndSlowPointers;

class PalindromicLinkedList {

  public static boolean isPalindrome(ListNode head) {
    ListNode fast = head,slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode secondHalf = reverse(slow);
    ListNode copy = secondHalf;
    while (head != null && secondHalf != null) {
      if (head.value != secondHalf.value) {
        break;
      }
      head = head.next;
      secondHalf = secondHalf.next;
    }
    reverse(copy);
    return head == null || secondHalf == null;
  }

  static ListNode reverse(ListNode head) {
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
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
  }
}