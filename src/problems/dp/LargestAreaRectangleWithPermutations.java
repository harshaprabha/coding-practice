package problems.dp;

public class LargestAreaRectangleWithPermutations {

  public static void main(String[] args) {
    int[][] A = {{0, 1, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 0, 0, 0, 0}};
    int R = A.length;
    int C = A[0].length;
    int[][] count = new int[R][C];

    //count array
    for (int j = 0; j < C; j++) {
      int sum = 0;
      for (int i = 0; i < R; i++) {
        if (A[i][j] == 1) {
          sum += 1;
          count[i][j] = sum;
        } else {
          sum = 0;
          count[i][j] = sum;
        }

      }//for
    }//for

    int[][] countOut = new int[R][C];
    //Sort count array using counting sort

    //for every row, do count sort
    for (int k = 0; k < R; k++) {

      // find Max value
      int max = Integer.MIN_VALUE;
      for (int z = 0; z < C; z++) {
        max = max < count[k][z] ? count[k][z] : max;
      }

      int countingSort[] = new int[max + 1];
      //for every column compute prefix sum
      for (int c = 0; c < C; c++) {
        countingSort[count[k][c]] += 1;
      }

      for (int c = 1; c < countingSort.length; c++) {
        countingSort[c] += countingSort[c - 1];
      }

      // fill output array
      for (int m = 0; m < C; m++) {
        countOut[k][countingSort[count[k][m]] - 1] = count[k][m];
        countingSort[count[k][m]] = countingSort[count[k][m]] - 1;
      }

    }

    //find max area

    int maxarea = Integer.MIN_VALUE;

    for (int p = 0; p < R; p++) {
      for (int q = C - 1; q >= 0; q--) {
        maxarea = maxarea < (C - q) * countOut[p][q] ? (C - q) * countOut[p][q] : maxarea;
      }
    }
    System.out.println(maxarea);


  }


}
