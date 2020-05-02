package problems.trees.construction;

import problems.trees.Node;

public class GivenInOrderAndPreOrder {


  static int k = -1;

  public static void main(String[] args) {

    int[] in = {4, 2, 5, 1, 3, 6};
    int[] pre = {1, 2, 4, 5, 3, 6};

    Node re = new GivenInOrderAndPreOrder().constructTree(0, in.length-1, in, pre);
    return;
  }

  //O(n2)
  Node constructTree(int start, int end, int[] in, int[] pre) {

    k=k+1;
    if (k > in.length) {
      return null;
    }

    if (start > end) {
      return null;
    }

    if (start == end) {
      return new Node(in[start]);
    }

    Node root = new Node(pre[k]);

    int index = findInInorder(pre[k], in);

    root.left = constructTree(start, index - 1, in, pre);
    root.right = constructTree(index + 1, end, in, pre);

    return root;
  }

  //O(n)
  int findInInorder(int value, int[] inorder) {

    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == value) {
        return i;
      }
    }

    return 0;
  }


}
