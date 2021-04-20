package problems.contests.codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

public class PlayChess {


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    solution(in, out);
    in.close();
    out.close();
  }

  public static void solution(Scanner in, PrintWriter out) {
    //type = 0 (number of test cases known), 1 (only 1 test case), 2 (number of test cases unknown)
    String line = in.nextLine();
    String[] inp = line.split(" ");

    int[] inpArr = new int[4];
    for (int t = 0; t < 4; t++) {
      inpArr[t] = Integer.parseInt(inp[t]);
    }

    int n = inpArr[0];
    int m = inpArr[1];
    int x = inpArr[2];
    int y = inpArr[3];

    boolean[][] visited = new boolean[n + 1][m + 1];

    dfs(x, y, n, m, visited, out);

  }


  static void dfs(int x, int y, int n, int m, boolean[][] visited, PrintWriter out) {

    visited[x][y] = true;
    out.println(x + " " + y);
    int X[] = {-1, 1, 0, 0};
    int Y[] = {0, 0, -1, 1};

    for (int i = 0; i < 4; i++) {
      int x1 = X[i] + x;
      int y1 = Y[i] + y;
      if ((x1 >= 1 && x1 <= n && y1 >= 1 && y1 <= m) && !visited[x1][y1]) {
        dfs(x1, y1, n, m, visited, out);

      }

    }//for

  }

}
