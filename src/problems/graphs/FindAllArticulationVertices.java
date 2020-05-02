package problems.graphs;

public class FindAllArticulationVertices {

  public static void main(String[] args) {

    Graph graph = new Graph(6);
    graph.addEdge(1, 2);
    graph.addEdge(1, 6);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);

    new FindAllArticulationVertices().findAllArticulationVertices(1,graph);

  }

  void findAllArticulationVertices(int vertex, Graph graph){






  }

}
