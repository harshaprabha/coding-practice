package problems.sorting;

/**
 * Time Complexity : O(n2) in worst case
 *                   O(n) in best case
 */

public class InsertionSort implements Sort {

  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 1, 7, 8};

    Sort sort = new InsertionSort();
    sort.sort(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

  }

  @Override
  public void sort(int A[], int n) {
    int temp;
    int index = -1;

    for (int i = 1; i < n; i++) {
      temp = A[i];
      index = i;
      for (int j = i - 1; j >= 0; j--) {
        if ((A[j] > temp)) {
          A[j + 1] = A[j];
          index = j;
        }
      }
      A[index] = temp;
    }


  }
}
