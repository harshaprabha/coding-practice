package problems.linkedList;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/palindrome-list/">
 * Palindrome List</a>
 * <p>Time Complexity - O(n) </p>
 * <p>Space Complexity - O(1) </p>
 *
 * @author Harsha Prabha E
 */
public class PalindromeList {

  public static void main(String[] args) {

    ListNode A = new ListNode(1);
    A.next = new ListNode(2);
    A.next.next = new ListNode(2);
    A.next.next.next = new ListNode(1);
    System.out.println(new PalindromeList().lPalin(A));
  }

  public int lPalin(ListNode A) {

    ListNode head = A;
    int l = 0;
    while (head != null) {
      l++;
      head = head.next;
    }

    l = l % 2 == 0 ? l / 2 : l / 2 + 1;
    int c = l;
    head = A;
    while (l > 1) {
      head = head.next;
      l--;
    }

    ListNode prev = head;
    ListNode next = head.next;
    ListNode temp = null;

    while (next != null) {

      temp = next.next;
      next.next = prev;

      prev = next;
      next = temp;
    }

    head = A;
    while (head != prev && c > 0) {
      if (head.val != prev.val) {
        return 0;
      }
      head = head.next;
      prev = prev.next;
      c--;

    }
    return 1;

  }

}





