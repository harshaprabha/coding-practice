package problems.trees.leetcode;

import javax.swing.tree.TreeNode;

public class RangeSumOfBST {


  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
      val = x;
    }
  }

  static int sum = 0;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(10);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(11);
    root.right = new TreeNode(16);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(29);

    System.out.println(new RangeSumOfBST().rangeSumBST(root, 10, 20));

  }



  public int rangeSumBST(TreeNode root, int L, int R) {

    int result = 0;
    if (root == null) {
      return result;
    }
    getInOrderNodes(root, L, R);

    return sum;
  }


  static void getInOrderNodes(TreeNode root, int L, int R) {

    if (root == null) {
      return;
    }

    if (root.val >= L && root.val <= R) {
      sum += root.val;
    }

    if (root.val < L || root.val > R) {
      return;
    }

    getInOrderNodes(root.left, L, R);
    getInOrderNodes(root.right, L, R);


  }

}
