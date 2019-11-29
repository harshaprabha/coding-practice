package problems.matrix;
/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/set-matrix-zeros/"> Set
 * Matrix Zeroes</a>
 * <p>Time Complexity - O(n*m) </p>
 * <p> Space Complexity - O(1) </>
 *
 * @author Harsha Prabha E
 */

import java.util.ArrayList;

public class SetMatrixZeros {

  public static void main(String[] args) {

    System.out.println(Integer.MAX_VALUE);

    SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
    ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
    A.add(0, new ArrayList<Integer>() {{
      add(0, 0);
      add(0, 0);
    }});
    A.add(1, new ArrayList<Integer>() {{
      add(0, 1);
      add(0, 1);
    }});

    setMatrixZeros.setZeroes(A);
    for (int i = 0; i < A.size(); i++) {
      for (int j = 0; j < A.get(0).size(); j++) {
        System.out.print(A.get(i).get(j) + " ");
      }
      System.out.println();
    }

  }

  public void setZeroes(ArrayList<ArrayList<Integer>> A) {

    int R = A.size();
    int C = A.get(0).size();

    int flag = 0;
    if (C == 1) {
      for (int p = 0; p < R; p++) {
        if (A.get(p).get(0) == 0) {
          flag = 1;
        }

      }

      if (flag == 1) {
        for (int p = 0; p < R; p++) {
          A.get(p).set(0, 0);

        }

      }
      return;
    }

    if (R == 1) {
      for (int p = 0; p < C; p++) {
        if (A.get(0).get(p) == 0) {
          flag = 1;
        }

      }

      if (flag == 1) {
        for (int p = 0; p < R; p++) {
          A.get(0).set(p, 0);

        }
      }
      return;
    }

    int firstflag = 0;

    //last iterate the first column
    for (int p = 0; p < R; p++) {
      if (A.get(p).get(0) == 0) {
        firstflag = 1;
      }

    }

    //check rows for zeroes
    for (int k = 0; k < R; k++) {
      int count = 0;
      for (int l = 0; l < C; l++) {
        if (A.get(k).get(l) == 1) {
          count++;
        }
      }
      count = (A.get(k).get(0) == 0) ? 0 : count;
      A.get(k).set(0, count);
    }

    //check columns for zeroes
    for (int i = C - 1; i > 0; i--) {
      int count = 0;
      for (int j = 0; j < R; j++) {
        if (A.get(j).get(i) == 1) {
          count++;
        }
      }

      count = (A.get(0).get(i) == 0) ? 0 : count;
      A.get(0).set(i, count);
    }

    //iterate on column

    for (int i = C - 1; i > 0; i--) {
      if (A.get(0).get(i) == 0 || A.get(0).get(i) < R) {
        for (int j = 0; j < R; j++) {
          A.get(j).set(i, 0);

        }
      } else {
        A.get(0).set(i, 1);
      }

    }

    //iterate on rows
    for (int k = 0; k < R; k++) {
      if (A.get(k).get(0) == 0 || A.get(k).get(0) < C) {
        for (int j = 0; j < C; j++) {
          A.get(k).set(j, 0);

        }
      } else {
        A.get(k).set(0, 1);
      }

    }

    if (firstflag == 1) {
      for (int p = 0; p < R; p++) {
        A.get(p).set(0, 0);

      }
    }


  }

}
