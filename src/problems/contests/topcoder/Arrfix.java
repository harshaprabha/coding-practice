package problems.contests.topcoder;

public class Arrfix {

  public static void main(String[] args) {
    int A[] = {1, 1, 1};
    int B[] = {2, 2, 2};
    int F[] = {2};
    System.out.println(new Arrfix().mindiff(A, B, F));

  }

  public int mindiff(int[] A, int[] B, int[] F) {

    int n = A.length;
    int sticker_count = F.length;
    int edit = 0;
    int s = sticker_count;
    boolean sticked[] = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (A[i] != B[i] && !sticked[i]) {
        edit++;

        for (int j = 0; j < sticker_count; j++) {
          //found sticker
          if (B[i] == F[j]) {
            edit--;

            sticked[i] = true;
            F[j] = 0; // remove sticker
            s--;
            A[i] = B[i]; //stick it
          }

        }
      }//if
    }//for

    if (s > 0) {
      for (int k = 0; k < n; k++) {
        // spend duplicate ones
        for (int l = 0; l < sticker_count; l++) {
          if (A[k] == F[l] && !sticked[k]) {
            F[l] = 0;
            s--;
          }
        }

      }


    }

    return edit + s;


  }

}
