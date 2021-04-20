package problems.trees;

public class KthSmallestInPerfectBST {

  static Node ans = null;

  public static void main(String[] args) {
    Node A = new Node(4);
    A.left = new Node(2);
    A.left.left = new Node(1);
    A.left.right = new Node(3);
    A.right = new Node(7);
    A.right.left = new Node(6);
    A.right.right = new Node(8);

    Node temp = A;
    int h = 0;
    while (temp != null) {
      temp = temp.left;
      h++;
    }

    findKthElement(A, 1, (int) Math.pow(2, h) - 1, 5);
    System.out.println(ans.value);
  }


  static boolean findKthElement(Node root, int start, int end, int k) {

    if (root == null) {
      return false;
    }

    int mid = (start + end) / 2;
    if (mid == k && ans == null) {
      ans = root;
      return true;
    } else if (k > mid) {
      if (findKthElement(root.right, mid + 1, end, k)) {
        return true;
      }
    } else if (findKthElement(root.left, start, mid - 1, k)) {
      return true;
    }
    return false;
  }


}
