package problems.sorting;

/**
 * Time Complexity : O(n^2)
 *
 * @author Harsha Prabha E
 * @see problems.sorting.Sort
 */
public class BubbleSort implements Sort {

  public static void main(String[] args) {
    int[] arr = {9, 4, 6, 2, 1, 11, 8, 0, -8};

    Sort sort = new BubbleSort();
    sort.sort(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  @Override
  public void sort(int[] A, int n) {

    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {

        if (A[j] > A[j + 1]) {
          int temp = A[j];
          A[j] = A[j + 1];
          A[j + 1] = temp;
        }
      }
    }


  }
}
