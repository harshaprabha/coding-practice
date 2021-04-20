package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class PreOrderLevelConstruction {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode res = new PreOrderLevelConstruction().recoverFromPreorder("1-2--3---4-5--6---7");
    new PreOrderLevelConstruction().printTree(res);
  }

  void printTree(TreeNode res) {
    if (res == null) {
      return;
    }

    System.out.println(res.val);
    printTree(res.left);
    printTree(res.right);

  }


  int n = 0;

  public TreeNode recoverFromPreorder(String s) {

    n = s.length();

    return constructTree(0, n, s);

  }

  TreeNode constructTree(int start, int end, String s) {
    int dashCount = 0;
    if (start > n || end > n || start >= end) {
      return null;
    }
    TreeNode root = new TreeNode(s.charAt(start) - '0');

    //Find left
    int k = start + 1;
    while (k < end && s.charAt(k) == '-') {
      dashCount++;
      k++;
    }

    int left = k;
    Map<Integer,List<Integer>> map= new HashMap<>();
    Set<Entry<Integer,List<Integer>>> entries= map.entrySet();
    List<Entry<Integer,List<Integer>>> ent= new ArrayList<>(entries);
    Collections.sort(ent,(a,b)->a.getKey()-b.getKey());
     Queue<Integer> queue= new LinkedList<>();

 ((LinkedList<Integer>) queue).removeLast();
    //Find right with left level

    int right = -1;
    //search in rest
    for (int r = k + 1; r < end; r++) {
      int rightCount = 0;
      while (r < end && s.charAt(r) == '-') {
        rightCount++;
        r++;
      }

      if (rightCount == dashCount) {
        right = r;
        break;
      }

    }

    right = right == -1 ? end : right;
    root.left = constructTree(left, right, s);
    root.right = constructTree(right, end, s);

    return root;

  }
}
