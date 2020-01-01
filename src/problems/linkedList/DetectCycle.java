package problems.linkedList;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/list-cycle/"> Detect Cycle
 * Linked List</a>
 * <p>Time Complexity - O(n) </p>
 *
 * @author Harsha Prabha E
 */
public class DetectCycle {

  public static void main(String[] args) {
    ListNode A = new ListNode(9);
    A.next = new ListNode(9);
    A.next.next = A.next;
    ListNode result = new DetectCycle().detectCycle(A);
    System.out.println(result == null ? null : result.val);
  }

  public ListNode detectCycle(ListNode a) {
    ListNode start = a;
    ListNode fast = a;
    ListNode slow = a;
    if (a == null || a.next == null) {
      return a;
    }

    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }

    }

    if (slow == null || fast == null || fast.next == null) {
      return null;
    }

    while (start != slow) {
      start = start.next;
      slow = slow.next;

    }

    return start;

  }

}
