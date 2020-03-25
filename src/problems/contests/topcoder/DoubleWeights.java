package problems.contests.topcoder;


import java.util.ArrayList;
import java.util.Stack;

public class DoubleWeights {

  static long min = Integer.MAX_VALUE;

  public static void main(String[] args) {
    String weight1[] = {"..14",
        "..94",
        "19..",
        "44.."};
    String weight2[] = {"..94",
        "..14",
        "91..",
        "44.."};
    // new DoubleWeights().cheapestPath(0, 1, A);

    boolean visited[] = new boolean[weight1.length];
    visited[0] = true;
    // new DoubleWeights().dfs(0, 1, weight1, weight2, 0, 0, visited);
    new DoubleWeights().dfs(1, weight1, weight2);
    //System.out.println(min == Integer.MAX_VALUE ? -1 : min);
  }


  //All paths from source to destination
  void dfs(int current, int destination, String[] weight1, String[] weight2,
      int weight1Sum, int weight2Sum,
      boolean[] visited) {

    if (current == destination) {
      min = Math.min(min, weight1Sum * weight2Sum);
      return;
    }

    for (int i = 0; i < weight1.length; i++) {
      //path exists
      if (weight1[current].charAt(i) != '.' && !visited[i]) {

        dfs(i, destination, weight1, weight2,
            weight1Sum + weight1[current].charAt(i) - '0',
            weight2Sum + weight2[current].charAt(i) - '0', visited);

      }
    }
    visited[current] = true;

  }


  //DFS Using Stacks
  void dfs(int destination, String[] weight1, String[] weight2) {

    boolean[] visited = new boolean[weight1.length];

    Stack<Integer> stack = new Stack<>();
    visited[0] = true;
    stack.push(0);
    long min = Integer.MAX_VALUE;
    ArrayList<Integer> path = new ArrayList<>();

    while (!stack.isEmpty()) {

      int current = stack.pop();
      path.add(current);
      if (current == destination) {
        visited[destination] = false;
        System.out.println(path);
        //add value
        path.remove(path.size() - 1);
        continue;
      }

      for (int i = 0; i < weight1.length; i++) {
        //path exists
        if (weight1[current].charAt(i) != '.' && !visited[i] && current != i) {
          visited[i] = true;
          stack.push(i);

        } else {
          visited[i] = false;
        }

      }//for


    }//while

  }

}
