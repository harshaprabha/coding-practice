package problems.trees;

import java.util.ArrayList;
import java.util.Arrays;

public class InorderTraversalOfCartesianTree {

  public static void main(String[] args) {
    System.out.println(new InorderTraversalOfCartesianTree()
        .buildTree(new ArrayList<Integer>(Arrays
            .asList(484, 221, 964, 787, 965, 134, 30, 764, 98, 931, 150, 854, 982, 396, 538, 317,
                287, 960, 885, 993, 601, 82, 390, 355, 375, 54, 972, 178, 570, 326, 331, 668,
                265))));

  }

  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }
  }

  public TreeNode buildTree(ArrayList<Integer> A) {
    if (A.size() == 0) {
      return null;
    }
    TreeNode root = constructTree(A, 0, A.size() - 1);
    return root;
  }

  public TreeNode constructTree(ArrayList<Integer> A, int start, int end) {
    if (start > end || start < 0 || end > A.size() - 1) {
      return null;
    }

    if (start == end) {
      TreeNode node = new TreeNode(A.get(start));
      return node;
    }

    int maxIndex = getMaxIndex(A, start, end);

    if (maxIndex == -1) {
      return null;
    }

    TreeNode root = new TreeNode(A.get(maxIndex));
    root.left = constructTree(A, start
        , maxIndex - 1);
    root.right = constructTree(A, maxIndex + 1, end);

    return root;

  }


  public int getMaxIndex(ArrayList<Integer> A, int start, int end) {
    int maxIndex = -1;
    int maxValue = Integer.MIN_VALUE;
    for (int i = start; i <= end; i++) {
      if (A.get(i) > maxValue) {
        maxValue = A.get(i);
        maxIndex = i;
      }
    }
    return maxIndex;
  }


}
