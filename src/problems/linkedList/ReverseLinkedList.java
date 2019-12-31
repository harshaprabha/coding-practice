package problems.linkedList;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/reverse-linked-list/">
 * Reverse Linked List</a>
 * <p>Time Complexity - O(n) </p>
 * <p>Space Complexity - O(1) </p>
 *
 * @author Harsha Prabha E
 */

public class ReverseLinkedList {

  ListNode start = null;

  public static void main(String[] args) {
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    a.next.next = new ListNode(3);
    a.next.next.next = new ListNode(4);

    reverseLinkedList.printLL(reverseLinkedList.reverseList(a));
  }

  public void printLL(ListNode start) {
    while (start != null) {
      System.out.println(start.val);
      start = start.next;
    }
  }

  /*
  Method 1: Iterative
   */
  public ListNode reverseList(ListNode A) {
    if (A == null) {
      return A;
    }
    ListNode prev = null;
    ListNode next = A;
    ListNode temp = null;

    while (next != null) {

      temp = next.next;
      next.next = prev;
      prev = next;
      next = temp;

    }
    return prev;
  }

  /*
  Method 2: Recursive
   */
  ListNode reverse(ListNode next, ListNode prev) {
    if (next == null) {
      start = prev;
      return prev;
    }
    ListNode temp = reverse(next.next, next);

    temp.next = prev;
    return prev;
  }
}




