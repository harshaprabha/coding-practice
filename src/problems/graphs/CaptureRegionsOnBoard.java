package problems.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CaptureRegionsOnBoard {

  public static void main(String[] args) {
    ArrayList<ArrayList<Character>> A = new ArrayList<>();
    String one = "XXX";
    String two = "XOX";
    String three = "XXX";

    ArrayList<Character> list = new ArrayList<>();

    for (int i = 0; i < one.length(); i++) {
      list.add(one.charAt(i));
    }

    A.add(list);

    list = new ArrayList<Character>();
    for (int i = 0; i < two.length(); i++) {
      list.add(two.charAt(i));
    }
    A.add(list);

    list = new ArrayList<Character>();
    for (int i = 0; i < three.length(); i++) {
      list.add(three.charAt(i));
    }
    A.add(list);
    System.out.println(A);

    solve(A);
    System.out.println(A);

  }

  public static void solve(ArrayList<ArrayList<Character>> A) {
    int R = A.size();
    int C = A.get(0).size();

    if (R <= 2 || C <= 1) {
      return;
    }

    boolean componentInBorder = false;
    Boolean markQualified[][] = new Boolean[R][C];
    for (int k = 0; k < R; k++) {
      Arrays.fill(markQualified[k], true);
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (A.get(i).get(j) == 'O' && markQualified[i][j]) {
          bfs(A, i, j, markQualified, componentInBorder);
        }
      }
    }

  }

  static class Pair {

    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }


  static void bfs(ArrayList<ArrayList<Character>> A, int i, int j, Boolean markQualified[][],
      boolean componentInBorder) {
    Queue<Pair> queue = new LinkedList<>();
    Stack<Pair> stack = new Stack<>();

    int row = A.size();
    int col = A.get(0).size();

    Pair one = new Pair(i, j);
    queue.add(one);
    stack.add(one);
    markQualified[i][j] = false;

    int X[] = new int[]{0, -1, 0, 1};
    int Y[] = new int[]{-1, 0, 1, 0};

    while (!queue.isEmpty()) {

      Pair pair = queue.remove();
      int x = pair.x;
      int y = pair.y;
      // all 4 paths
      for (int k = 0; k < 4; k++) {
        int x1 = x + X[k];
        int y1 = y + Y[k];

        //valid boundaries
        if (x1 >= 0 && x1 < row && y1 >= 0 && y1 < col && A.get(x1).get(y1) == 'O'
            && markQualified[x1][y1]) {

          markQualified[x1][y1] = false;
          queue.add(new Pair(x1, y1));
          stack.add(new Pair(x1, y1));

          if (x1 <= 0 || x1 >= row - 1 || y1 <= 0 || y1 >= col - 1) {
            componentInBorder = true;
          }


        }
        //outside range
        else if (x1 < 0 || x1 > row - 1 || y1 < 0 || y1 > col - 1) {
          componentInBorder = true;
        }

      }

    }//while

    while (!stack.isEmpty()) {
      Pair item = stack.pop();
      if (componentInBorder) {
        markQualified[item.x][item.y] = false;
      } else {
        ArrayList<Character> list = A.get(item.x);
        list.set(item.y, 'X');
        A.set(item.x, list);
      }

    }


  }


}
