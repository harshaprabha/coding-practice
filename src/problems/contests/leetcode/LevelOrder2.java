package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder2 {

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    System.out.println(new LevelOrder2().levelOrderBottom(root));;

  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    if (root == null) {
      return result;
    }

    queue.add(root);
    queue.add(new TreeNode(-1));

    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      if (node.val == -1) {
        if (queue.isEmpty()) {
          break;
        }
        queue.add(new TreeNode(-1));
      }

      stack.add(node.val);

      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }

    }

    System.out.println(stack.size());
    while (!stack.isEmpty()) {

      List<Integer> list = new ArrayList<>();
      while (!stack.isEmpty()) {
        int ele = stack.pop();
        if (ele == -1) {
          result.add(list);
          break;
        } else {
          list.add(0, ele);
        }

      }


    }
    return result;

  }
}
