package problems.linkedList;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/">
 * Remove Duplicates From Sorted List
 * </a>
 * <p>Time Complexity - O(n) </p>
 * <p>Space Complexity - O(1) </p>
 *
 * @author Harsha Prabha E
 */
public class RemoveDuplicatesFromSortedList {

  public static void main(String[] args) {
    ListNode A = new ListNode(0);
    A.next = new ListNode(1);
    A.next.next = new ListNode(1);
    A.next.next.next = new ListNode(1);
    A.next.next.next.next = new ListNode(2);
    A.next.next.next.next.next = new ListNode(2);

    RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
    removeDuplicatesFromSortedList.printLL(removeDuplicatesFromSortedList.deleteDuplicates(A));
  }


  public void printLL(ListNode start) {
    while (start != null) {
      System.out.println(start.val);
      start = start.next;
    }
  }

  public ListNode deleteDuplicates(ListNode A) {

    if (A == null || A.next == null) {
      return A;
    }

    ListNode prev = null;
    ListNode curr = A;
    ListNode start = A;
    int val = curr.val;
    prev = curr;
    curr = curr.next;
    while (curr != null) {

      if (curr.val == val) {
        //delete
        ListNode temp = curr.next;
        curr.next = null;
        prev.next = temp;
        curr = temp;

      } else {
        val = curr.val;
        prev = curr;
        curr = curr.next;
      }


    }

    return start;


  }

}
