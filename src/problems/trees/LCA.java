package problems.trees;

import java.util.ArrayList;
import java.util.List;


public class LCA {

  public static void main(String[] args) {
    Node A = new Node(11);
    A.left = new Node(3);
    A.right = new Node(2);

    A.left.left = new Node(4);
    A.left.right = new Node(1);
    System.out.println(new LCA().lca(A, 1, 2));
  }

  public int lca(Node A, int B, int C) {
    List<Integer> pathA = new ArrayList<>();
    List<Integer> pathB = new ArrayList<>();
    if (!isPathPresent(A, B, pathA) || !isPathPresent(A, C, pathB)) {
      return -1;
    }
    int i = 0;
    int max = Math.min(pathA.size(), pathB.size()) - 1;

    while (i <= max && pathA.get(i) == pathB.get(i)) {
      i++;
    }

    i = i > 0 ? i - 1 : i;
    return pathA.get(i);

  }

  public boolean isPathPresent(Node A, int ele, List<Integer> path) {
    if (A == null) {
      return false;
    }

    path.add(A.value);

    if (A.value == ele) {
      return true;
    }

    if (isPathPresent(A.left, ele, path) || isPathPresent(A.right, ele, path)) {
      return true;
    }

    path.remove(path.size() - 1);

    return false;

  }


}
