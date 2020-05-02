package problems.trees;

import javafx.util.Pair;

public class FlattenBinaryTree {

  public static void main(String[] args) {
    Node A = new Node(1);
    A.left = new Node(2);
    A.right = new Node(5);
    A.right.right = new Node(6);

    A.left.left = new Node(3);
    A.left.right = new Node(4);


    new FlattenBinaryTree().flatten(A);
  }

  public void flatten(Node root) {
    Pair<Integer,Boolean> link= new Pair<>(1,true);

    if(root==null)
      return;

    flatten(root.left);
    flatten(root.right);

    Node temp= root.right;

    if(root.left!=null)
    {
      root.right=root.left;
      root.left=null;

      Node curr= root.right;
      while(curr.right!=null)
        curr=curr.right;

      if(temp!=null)
        curr.right=temp;
    }



  }


}
