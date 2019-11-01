package problems.sorting;

/**
 * Time Complexity : O(n^2)
 */
public class SelectionSort implements Sort {

  public static void main(String[] args) {
    int[] arr = {9, 4, 6, 2, 1, 11, 8, 0, -8};

    Sort sort = new SelectionSort();
    sort.sort(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  @Override
  public void sort(int[] A, int n) {

    for (int i = 0; i < n; i++) {
      int small = A[i];
      int small_index = i;

      for (int j = i + 1; j < n; j++) {
        if (A[j] < small) {
          small = A[j];
          small_index = j;
        }
      }

      int temp = A[i];
      A[i] = A[small_index];
      A[small_index] = temp;

    }


  }
}
