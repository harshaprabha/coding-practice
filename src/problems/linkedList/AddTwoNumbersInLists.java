package problems.linkedList;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/add-two-numbers-as-lists/">
 * Add Two Numbers Linked List</a>
 * <p>Time Complexity - O(n) </p>
 * <p>Space Complexity - O(n) </p>
 *
 * @author Harsha Prabha E
 */

public class AddTwoNumbersInLists {

  public static void main(String[] args) {
    AddTwoNumbersInLists addTwoNumbersInLists = new AddTwoNumbersInLists();
    ListNode A = new ListNode(9);
    A.next = new ListNode(9);
    A.next.next = new ListNode(1);
    ListNode B = new ListNode(9);
    addTwoNumbersInLists.printLL(addTwoNumbersInLists.addTwoNumbers(A, B));

  }

  public void printLL(ListNode start) {
    while (start != null) {
      System.out.println(start.val);
      start = start.next;
    }
  }

  public ListNode addTwoNumbers(ListNode A, ListNode B) {

    ListNode R = null;
    ListNode start = null;
    int carry = 0;
    while (A != null || B != null) {
      int aval = A == null ? 0 : A.val;
      int bval = B == null ? 0 : B.val;
      int result = aval + bval + carry;
      carry = result < 10 ? 0 : 1;
      result = result % 10;
      if (R == null) {
        R = new ListNode(result);
        start = R;
      } else {
        R.next = new ListNode(result);
        R = R.next;
      }

      if (A != null) {
        A = A.next == null ? null : A.next;
      }
      if (B != null) {
        B = B.next == null ? null : B.next;
      }
    }

    if (carry != 0) {
      R.next = new ListNode(carry);
    }

    return start;


  }


}
