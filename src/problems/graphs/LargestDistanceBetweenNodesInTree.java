package problems.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LargestDistanceBetweenNodesInTree {

  int max = Integer.MIN_VALUE;

  public static void main(String[] args) {
    System.out.println(new LargestDistanceBetweenNodesInTree()
        .solve(new int[]{-1, 0, 0, 0, 1, 1, 1, 4, 5, 7, 3}));
  }

  public int solve(int[] A) {
    int N = A.length;
    Node root = null;
    Map<Integer, Node> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      Node newNode = new Node(i);
      map.put(i, newNode);
      //parent of root
      if (A[i] == -1) {
        root = newNode;
      } else {
        Node parent = map.get(A[i]);
        parent.children.add(newNode);
      }
    }//for



    //find the farthest node using BFS

    //Find largest distant node from farthest node using dfs


    return max;

  }


  public int dfs(Node root) {

    ArrayList<Integer> result = new ArrayList<>();
    result.add(0);
    result.add(0);

    if (root.children.size() == 0) {
      return 0;
    }
    Iterator<Node> iter = root.children.iterator();

    while (iter.hasNext()) {
      Node child = iter.next();
      int height = 0;

      height = 1 + dfs(child);
      result.add(height);

    }//while

    Collections.sort(result);
    max = Math.max(max, result.get(result.size() - 1) + result.get(result.size() - 2));
    root.max = result.get(result.size() - 1);

    return root.max;

  }



  class Node {

    int value;
    List<Node> children;
    int max;

    Node(int v) {
      children = new ArrayList<>();
      this.value = v;
      this.max = 0;
    }
  }

}
