package problems.trees;

public class FlattenBinaryTree {

  public static void main(String[] args) {
    Node A = new Node(1);
    A.left = new Node(2);
    A.right = new Node(3);
    A.right.right = new Node(7);
    A.right.right.left = new Node(8);
    A.right.right.right = new Node(9);

    A.right.left = new Node(4);
    A.right.left.left = new Node(5);

    A.right.left.left.right = new Node(6);

    System.out.println(new FlattenBinaryTree().flatten(A));
  }

  public Node flatten(Node a) {
    flatTree(a);
    return a;

  }

  void flatTree(Node root) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      return;
    }

    if (root.left == null && root.right != null) {
      return;
    }

    flatTree(root.left);
    flatTree(root.right);

    if (root.left != null && root.right == null) {
      root.right = root.left;
      root.left = null;
    }

    if (root.left != null && root.right != null) {
      Node temp = root.right;
      root.right = root.left;
      root.left = null;
      Node newNode = root.right;

      while (newNode.right != null) {
        newNode = newNode.right;
      }

      newNode.right = temp;
    }

    return;

  }


}
