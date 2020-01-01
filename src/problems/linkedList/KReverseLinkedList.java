package problems.linkedList;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/k-reverse-linked-list/"> K
 * Reverse Linked List</a>
 * <p>Time Complexity - O(n) </p>
 *
 * @author Harsha Prabha E
 */
public class KReverseLinkedList {

  public ListNode reverseList(ListNode A, int B) {

    if (A == null) {
      return A;
    }

    if (B == 1) {
      return A;
    }

    ListNode prev = null;
    ListNode curr = A;
    ListNode start = A;
    ListNode end = A;
    ListNode prevStart = null;
    boolean isHead = false;

    while (curr != null) {
      int c = B;
      start = curr;
      while (c > 0) {

        if (c == 1) {
          end = curr;
        }

        ListNode temp = curr.next;
        curr.next = prev;

        c--;
        prev = curr;
        curr = temp;
      }
      if (prevStart == null) {
        A = prev;
      } else {
        prevStart.next = end;
      }

      prevStart = start;

    }
    start.next = null;

    return A;


  }

}
