package problems.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

  int V;
  int E;
  boolean directed = false;

  public LinkedList<Integer> adjLists[];

  public Graph(int V) {
    this.V=V;
    adjLists= new LinkedList[V];
    for(int i=0;i<V;i++)
    {
      adjLists[i]= new LinkedList<>();
    }
  }

  public void addEdge(int startVertex, int endVertex) {
     adjLists[startVertex].add(endVertex);
  }


}
