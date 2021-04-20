package problems.contests.leetcode;

import problems.linkedList.ListNode;

public class PartitionList {

  public static void main(String[] args) {

    ListNode node= new ListNode(1);
    node.next=new ListNode(4);
    node.next.next=new ListNode(3);
    node.next.next.next=new ListNode(2);
    node.next.next.next.next =new ListNode(5);

    new PartitionList().partition(node,3);
  }

  public ListNode partition(ListNode head, int x) {

    ListNode leftStart=null;
    ListNode leftEnd=null;
    ListNode rightEnd=null;
    ListNode rightStart=null;
    ListNode curr = head;

    while(curr!=null)
    {
      if(curr.val<x)
      {
        if(leftStart==null)
        {
          leftStart=curr;
          leftEnd=leftStart;
        }
        else{
          leftEnd.next=curr;
          leftEnd=leftEnd.next;
        }

      }
      else
      {
        if(rightStart==null){
          rightStart=curr;
          rightEnd=rightStart;
        }
        else
        {
          rightEnd.next=curr;
          rightEnd=rightEnd.next;
        }
      }
      curr=curr.next;

    }

    if(leftEnd!=null)
      leftEnd.next=null;

    if(rightEnd!=null)
      rightEnd.next=null;

    if(leftStart==null)
      return rightStart;
    else if(rightStart==null)
      return leftStart;

    leftEnd.next=rightStart;
    return leftStart;
  }

}
