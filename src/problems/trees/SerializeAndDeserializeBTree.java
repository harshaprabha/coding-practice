package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBTree {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(5);

    SerializeAndDeserializeBTree ob = new SerializeAndDeserializeBTree();
    System.out.println(ob.serialize(root));
    printTree(ob.deserialize(ob.serialize(root)));


  }


  static void printTree(TreeNode root) {
    if (root == null) {
      return;
    }

    System.out.println(root.val);
    printTree(root.left);
    printTree(root.right);
  }


  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {

    if (root == null) {
      return "";
    }
    Queue<TreeNode> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    queue.add(root);

    while (!queue.isEmpty()) {

      TreeNode node = queue.remove();
      if (node.val == -1) {
        sb.append("null");
        if (!queue.isEmpty()) {
          sb.append(",");        // separator
        }
        continue;
      } else {
        sb.append(node.val);
      }

      if (node.left == null) {
        queue.add(new TreeNode(-1));
      } else {
        queue.add(node.left);
      }

      if (node.right == null) {
        queue.add(new TreeNode(-1));
      } else {
        queue.add(node.right);
      }

      if (!queue.isEmpty()) {
        sb.append(",");        // separator
      }
    }

    return sb.toString();

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    TreeNode root = null;
    String[] nodes = data.split(",");
    int i = 0;

    return buildTree(0, nodes);
  }

  TreeNode buildTree(int i, String[] nodes) {

    TreeNode root = null;

    if (i >= nodes.length) {
      return null;
    }

    if (nodes[i].equals("null")) {
      return null;
    }

    root = new TreeNode(Integer.parseInt(nodes[i]));

    root.left = buildTree(i + 1, nodes);
    root.right = buildTree(i + 2, nodes);

    return root;

  }


}
