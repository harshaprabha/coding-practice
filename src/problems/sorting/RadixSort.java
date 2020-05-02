package problems.sorting;

/**
 * Radix Sort Implementation in Java
 *
 * <p>Time Complexity - O(n) for all values in array within a
 * range 0 to K </p>
 * <p>Space Complexity - O(n+k)</p>
 *
 * @author Harsha Prabha E
 */
public class RadixSort implements Sort {


  public static void main(String[] args) {

    int[] arr = {1, 14, 31, 20, 1, 11};
    Sort sort = new RadixSort();

    sort.sort(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  @Override
  public void sort(int[] A, int n) {

    int max = A[0];
    //Find the maximum element
    for (int i = 1; i < n; i++) {
      if (A[i] > max) {
        max = A[i];
      }

      int c = 0;
      //Count the no of digits in the max element
      while (max > 0) {
        c++;
        max = max / 10;
      }

      for (int d = 0; d < c; d++) {

        int B[] = new int[n];

        int C[] = new int[10];

        int divisor = (int) (Math.pow(10, d));

        for (int j = 0; j < n; j++) {
          C[(A[j] / divisor) % 10] += 1;
        }

        for (int k = 1; k < C.length; k++) {
          C[k] += C[k - 1];
        }

        for (int l = 0; l < B.length; l++) {
          B[C[(A[l] / divisor) % 10] - 1] = A[l];
          C[(A[l] / divisor) % 10] = C[(A[l] / divisor) % 10] - 1;
        }

        for (int m = 0; m < B.length; m++) {
          A[m] = B[m];
        }

      }//d


    }


  }
}
