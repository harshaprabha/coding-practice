package problems.graphs;

import java.util.LinkedList;

 class WeightedGraph {

  int V;
  LinkedList<EdgeNode> adjList[];

  public WeightedGraph(int v) {
    this.V = v;
    this.adjList= new LinkedList[v];
    for (int i = 0; i < V; i++) {
      adjList[i] = new LinkedList<EdgeNode>();
    }
  }

  class EdgeNode {

    int vertex;
    int weight;

    public EdgeNode(int v, int w) {
      this.vertex = v;
      this.weight = w;
    }
  }


  public void addEdge(int startVertex, int endVertex, int weight) {
    adjList[startVertex].add(new EdgeNode(endVertex, weight));
  }
}