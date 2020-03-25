package problems.contests.topcoder;

public class P8XGraphBuilder {

  public static void main(String[] args) {

    int[] score = {2, 0};
    System.out.println(new P8XGraphBuilder().solve(score));
  }

  int solve(int[] scores) {
    int no_of_edges = scores.length;

    int no_of_nodes = no_of_edges + 1;

    int S = 2 * no_of_edges;
    int[] edges = new int[no_of_edges];

    for (int k = 0; k < no_of_edges; k++) {
      edges[k] = k + 1;
    }

    return maxScore(0, S, 0, edges, scores, no_of_nodes);

  }


  public int maxScore(int i, int S, int count, int[] edges, int[] scores, int nodes) {
    int maxScore = 0;

    // Set of nodes elements with sum S from set edges[]
    if (S == 0 && count == nodes) {
      return 0;
    }
    if (i > edges.length - 1) {
      return 0;
    }

    if (edges[i] <= S) {
      maxScore =
              Math.max(
                  scores[edges[i] - 1] + maxScore(i + 1, S - edges[i], count + 1, edges, scores,
                      nodes),
                  maxScore(i + 1, S, count, edges, scores, nodes));
    } else {
      maxScore = maxScore(i + 1, S, count, edges, scores, nodes);
    }

    return maxScore;

  }


}
