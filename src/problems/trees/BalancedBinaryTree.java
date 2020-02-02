package problems.trees;


public class BalancedBinaryTree {

  public static void main(String[] args) {
    Node A = new Node(11);
    A.left = new Node(3);
    A.right = new Node(2);

    A.left.left = new Node(4);
    A.left.right = new Node(1);
    //A.left.right.left = new Node(5);

    //A.right.left = new Node(3);
    //System.out.println(new BalancedBinaryTree().height(A));
    System.out.println(new BalancedBinaryTree().isBalanced(A));
  }

  public int isBalanced(Node A) {
    if (A == null) {
      return 0;
    }
    return Math.abs((height(A.left)) - (height(A.right))) > 1 ? 0 : 1;
  }

  public int height(Node A) {
    if (A == null) {
      return 0;
    }
    int l=1+height(A.left);
    int r=1+height(A.right);
    return l>r?l:r;


  }

}
