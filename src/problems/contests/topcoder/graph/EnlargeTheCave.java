package problems.contests.topcoder.graph;

public class EnlargeTheCave {

  static String[] result;
  static int desiredArea;

  public static void main(String[] args) {

    String[] cave = {"###K########",
        "#.#K########",
        "..#K########",
        "############"};
    new EnlargeTheCave().enlarge(cave, 10);

    for (int i = 0; i < cave.length; i++) {
      System.out.println(result[i]);
    }
  }


  public String[] enlarge(String[] cave, int d) {

    int m = cave.length;
    desiredArea = d;

    if (m == 0) {
      return new String[]{};
    }
    int n = cave[0].length();

    result = new String[m];
    int state[][] = new int[m][n];

    //initialize block areas
    int X[] = {1, -1, 0, 0};
    int Y[] = {0, 0, 1, -1};

    int dotCount = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (cave[i].charAt(j) == 'K') {
          for (int k = 0; k < 4; k++) {
            int x = i + X[k];
            int y = j + Y[k];
            if (x >= 0 && x < m && y >= 0 && y < n) {
              state[x][y] = 2; // mark it blocked
            }
          }
        } else if (cave[i].charAt(j) == '.') {
          dotCount++;
        }
      }
    }//end for

    if (dotCount >= desiredArea) {
      return cave;
    }

    //for all cave floors - '.'
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (cave[i].charAt(j) == '.' && state[i][j] == 0) // undiscovered
        {
          desiredArea = d;
          if (dfs(i, j, cave, state)) {
            return result;

          }

          //reset state
          for (int p = 0; p < m; p++) {
            for (int q = 0; q < n; q++) {
              if (state[i][j] == 1) {
                state[i][j] = 0;
              }
            }
          }//for


        }
      }
    }

    return new String[]{};


  }


  boolean dfs(int r, int c, String[] cave, int[][] state) {

    state[r][c] = 1;
    desiredArea = desiredArea - 1;

    if (desiredArea == 0) {
      // copy cave to this result
      for (int i = 0; i < cave.length; i++) {
        String row = "";
        for (int j = 0; j < cave[0].length(); j++) {
          if (state[i][j] == 1) {
            row += '.';
          } else {
            row += cave[i].charAt(j);
          }
        }
        result[i] = row;
      }

      return true;
    }

    int X[] = {1, -1, 0, 0};
    int Y[] = {0, 0, 1, -1};

    for (int k = 0; k < 4; k++) {
      int x = r + X[k];
      int y = c + Y[k];
      if (x >= 0 && x < cave.length && y >= 0 && y < cave[0].length()
          && state[x][y] == 0) {

        if (dfs(x, y, cave, state)) {
          return true;
        }

      }
    }

    return false;
  }

}
