package problems.trees;

public class ValidBST {

  public static void main(String[] args) {
    Node A = new Node(11);
    A.left = new Node(3);
    A.right = new Node(2);

    A.left.left = new Node(4);
    A.left.right = new Node(1);

    A.right.left = new Node(3);

    System.out.println(new ValidBST().isValidBST(A));
  }

  public int isValidBST(Node A) {

    return isBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) == true ? 1 : 0;

  }


  public boolean isBST(Node A, int min, int max) {
    if (A == null) {
      return true;
    }

    if (A.value < min || A.value > max) {
      return false;
    }

    if (isBST(A.left, min, A.value) && isBST(A.right, A.value, max)) {
      return true;
    }

    return false;
  }

}
