package problems.trees;

public class Node {

  public int value;
  public Node left;
  public Node right;
  Node inorder;

  public Node(int n) {
    this.value = n;
    this.left = null;
    this.right = null;
    this.inorder=null;
  }

  @Override
  public boolean equals(Object obj) {
    Node o = (Node) obj;
    return this.right == o.right && this.left == o.left && this.value == o.value;
  }
}
