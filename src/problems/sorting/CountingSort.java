package problems.sorting;

/**
 * Counting Sort Implementation in Java
 *
 * <p>Time Complexity - O(n) for all values in array within a
 * range 0 to K </p>
 * <p>Space Complexity - O(n+k)</p>
 *
 * @author Harsha Prabha E
 */
public class CountingSort implements Sort {

  public static void main(String[] args) {
    int[] arr = {1, 4, 8, 2, 1, 11, 8, 0, 1};

    Sort sort = new CountingSort();
    sort.sort(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }


  @Override
  public void sort(int[] A, int n) {

    //Array to store output
    int B[] = new int[n];

    // Find max element
    int max = A[0];
    for (int i = 1; i < n; i++) {
      if (A[i] > max) {
        max = A[i];
      }
    }

    //Temporary storage to hold count elements of array A
    int C[] = new int[max + 1];

    for (int j = 0; j < n; j++) {
      C[A[j]] += 1;
    }

    for (int k = 1; k < C.length; k++) {
      C[k] += C[k - 1];
    }

    for (int l = 0; l < A.length; l++) {
      B[C[A[l]] - 1] = A[l];
      C[A[l]] = C[A[l]] - 1;

    }

    for (int l = 0; l < A.length; l++) {
      A[l] = B[l];

    }

  }
}
