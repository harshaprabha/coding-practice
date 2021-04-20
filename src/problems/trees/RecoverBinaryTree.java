package problems.trees;


public class RecoverBinaryTree {
  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }
  }
  public static void main(String[] args) {

    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    new RecoverBinaryTree().recoverTree(root);

  }

  public void recoverTree(TreeNode root) {

    TreeNode curr=root;
    TreeNode prev = null;
    TreeNode first=null;
    TreeNode second=null;

    while(curr!=null)
    {
      // Find predecessor of every node
      TreeNode temp=curr.left;
      TreeNode pred=null;

      while(temp!=null && temp.val!=curr.val)
      {
        pred=temp;
        temp=temp.right;
      }

      if(prev!=null && prev.val>curr.val)
      {
        second=curr;
        if(first==null)
          first=prev;
      }

      // create links and traverse
      if(pred==null) // left subtree is null
      {
        // visit node and move right
        prev=curr;
        curr=curr.right;
      }
      else if (pred.right!=null) //and connection is made
      {
        prev=curr;
        curr=curr.right;
        pred.right=null; // remove connection made
      }
      else
      {
        pred.right=curr; // make connection
        curr=curr.left;
      }

    }

    if(first!=null && second!=null)
    {
      TreeNode temp= first;
      first.val=second.val;
      second.val=temp.val;
    }

  }

}
