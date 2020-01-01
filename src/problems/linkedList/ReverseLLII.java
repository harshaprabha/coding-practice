package problems.linkedList;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/reverse-link-list-ii/">
 * Reverse between range</a>
 * <p>Time Complexity - O(n) </p>
 * <p>Space Complexity - O(1) </p>
 *
 * @author Harsha Prabha E
 */

public class ReverseLLII {

  public static void main(String[] args) {
    ReverseLLII reverseLinkedList = new ReverseLLII();
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    a.next.next = new ListNode(3);
    reverseLinkedList.printLL(reverseLinkedList.reverseBetween(a, 1, 3));
  }

  public void printLL(ListNode start) {
    while (start != null) {
      System.out.println(start.val);
      start = start.next;
    }
  }

  public ListNode reverseBetween(ListNode A, int b, int c) {
    if (A == null || A.next == null) {
      return A;
    }

    boolean flag = false;
    ListNode head = A;
    if (b == 1) {
      flag = true;
    }

    if (b == c) {
      return A;
    }

    ListNode prev = null;
    ListNode next = A;
    ListNode B = A;
    ListNode C = A;
    int k = c - b;

    while (B != null && b > 1) {
      prev = B;
      B = B.next;
      b--;
    }
    ListNode start = B;

    while (C != null && c > 1) {
      C = C.next;
      next = C.next;
      c--;
    }

    ListNode before = prev;
    while (k >= 0) {
      ListNode temp = B.next;
      B.next = before;
      before = B;
      B = temp;

      k--;
    }

    start.next = next;

    if (prev != null) {
      prev.next = before;
    }

    return flag ? before : head;

  }

}
