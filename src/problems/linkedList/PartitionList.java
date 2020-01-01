package problems.linkedList;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/partition-list/"> Partition
 * List</a>
 * <p>Time Complexity - O(n) </p>
 * <p>Space Complexity - O(1) </p>
 *
 * @author Harsha Prabha E
 */
public class PartitionList {

  public static void main(String[] args) {
    PartitionList partitionList = new PartitionList();
    ListNode A = new ListNode(1);
    A.next = new ListNode(4);
    A.next.next = new ListNode(3);
    A.next.next.next = new ListNode(2);
    A.next.next.next.next = new ListNode(5);
    A.next.next.next.next.next = new ListNode(2);
    ListNode p = partitionList.partition(A, 3);
    partitionList.printLL(p);

  }

  public void printLL(ListNode start) {
    while (start != null) {
      System.out.println(start.val);
      start = start.next;
    }
  }

  public ListNode partition(ListNode A, int B) {

    if (A == null || A.next == null) {
      return A;
    }

    ListNode start = null;
    ListNode prev = null;
    ListNode curr = A;
    ListNode headSecond = A;
    boolean isheadFirst = false;
    boolean isheadSecond = false;
    ListNode headFirst = A;

    while (curr != null && curr.val < B) {
      start = curr;
      curr = curr.next;
    }

    while (curr != null) {
      if (curr.val < B) {
        //delete
        ListNode temp = curr.next;
        prev.next = temp;
        curr.next = null;

        //insert

        if (start == null) {
          ListNode newNode = new ListNode(curr.val);
          start = newNode;
          headFirst = start;
        } else {
          if (!isheadFirst) {
            isheadFirst = true;
            headFirst = start;
          }
          start.next = curr;
          start = curr;
        }
        //increment
        curr = temp;

      } else {
        if (!isheadSecond) {
          headSecond = curr;
          isheadSecond = true;

        }
        prev = curr;
        curr = curr.next;

      }

    }
    if (start != null) {
      start.next = headSecond;
    }

    return headFirst;

  }
}
