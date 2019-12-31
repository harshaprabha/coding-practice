package problems.linkedList;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/intersection-of-linked-lists/">
 * Intersection Linked List</a>
 * <p>Time Complexity - O(n) </p>
 * <p>Space Complexity - O(1) </p>
 *
 * @author Harsha Prabha E
 */
public class IntersectionLinkedList {

  public static void main(String[] args) {
    IntersectionLinkedList intersectionLinkedList = new IntersectionLinkedList();
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    a.next.next = new ListNode(3);
    a.next.next.next = new ListNode(4);

    ListNode b = new ListNode(5);
    b.next = new ListNode(6);
    b.next.next = a.next.next;
    b.next.next.next = a.next.next.next;
    ListNode intersection = intersectionLinkedList.getIntersectionNode(a, b);
    System.out.println("Intersection node is = " + intersection.val);

  }

  public ListNode getIntersectionNode(ListNode a, ListNode b) {

    ListNode astart = a;
    ListNode bstart = b;

    int alength = 0;
    int blength = 0;

    while (astart != null) {
      alength++;
      astart = astart.next;

    }

    while (bstart != null) {
      blength++;
      bstart = bstart.next;
    }

    if (alength == 0 || blength == 0) {
      return null;
    }

    int c = Math.abs(blength - alength);
    boolean isA = alength > blength ? true : false;

    while (c > 0) {
      if (isA) {
        a = a.next;
      } else {
        b = b.next;
      }
      c--;
    }

    while (a != null && b != null && a != b) {
      a = a.next;
      b = b.next;
    }

    return a;

  }
}
