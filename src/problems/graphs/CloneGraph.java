package problems.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

  public static void main(String[] args) {
    UndirectedGraphNode A = new UndirectedGraphNode(703);
    UndirectedGraphNode B = new UndirectedGraphNode(43);
    UndirectedGraphNode C = new UndirectedGraphNode(279);

    A.neighbors.add(A);
    A.neighbors.add(B);
    A.neighbors.add(C);

    B.neighbors.add(C);
    B.neighbors.add(A);

    C.neighbors.add(B);
    C.neighbors.add(C);
    C.neighbors.add(A);

    UndirectedGraphNode newA = cloneGraph(A);

    System.out.println(newA.toString());
  }

  static class UndirectedGraphNode {

    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
      label = x;
      neighbors = new ArrayList<>();
    }
  }

  ;

  public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

    UndirectedGraphNode root = new UndirectedGraphNode(node.label);
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    Map<Integer, Boolean> visited = new HashMap<>();
    visited.put(node.label, true);
    return clone(node, map, visited);


  }


  static public UndirectedGraphNode clone(UndirectedGraphNode node,
      Map<Integer, UndirectedGraphNode> map, Map<Integer, Boolean> visited) {

    int label = node.label;
    UndirectedGraphNode newNode;
    if (!map.containsKey(label)) {
      newNode = new UndirectedGraphNode(label);
      map.put(label, newNode);
    } else {
      newNode = map.get(label);
    }

    Iterator<UndirectedGraphNode> iterator = node.neighbors.iterator();
    while (iterator.hasNext()) {
      UndirectedGraphNode neighbor = iterator.next();
      UndirectedGraphNode newNeighbor;
      if (!map.containsKey(neighbor.label)) {
        newNeighbor = new UndirectedGraphNode(neighbor.label);
        map.put(neighbor.label, newNeighbor);
      } else {
        newNeighbor = map.get(neighbor.label);
      }
      newNode.neighbors.add(newNeighbor);

      if (!visited.containsKey(neighbor.label)) {
        visited.put(newNeighbor.label, true);
        clone(neighbor, map, visited);
      }

    }

    return newNode;


  }

}
