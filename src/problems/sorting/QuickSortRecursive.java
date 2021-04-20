package problems.sorting;

/**
 * Time Complexity : O(nlogn) n comparisons with tree height log N
 */

public class QuickSortRecursive implements Sort {

  public static void main(String[] args) {
    int[] arr = {1, 4, 3, 2, 7, 8, 1};

    Sort sort = new QuickSortRecursive();
    sort.sort(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

  }

  @Override
  public void sort(int[] A, int n) {
    quickSort(0, n - 1, A);
  }

  void quickSort(int low, int high, int[] A) {

    if (low >= high) { // no single element comparison like merge sort
      return;
    }

    int index = partition(low, high, A);
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i] + " ");
    }
    System.out.println();
    quickSort(low, index - 1, A);
    quickSort(index + 1, high, A);

  }

  // Invariant of this method = All elements <=
  // i will be less than pivot
  int partition(int low, int high, int[] A) {

    int pivot = A[high];// for random pivot, choose random pivot and swap with last to convert to this method

    int i = low - 1;
    int r = high - 1;

    for (int j = low; j <= r; j++) {
      if (A[j] < pivot) {
        i++;
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
      }
    }

    int temp = A[i + 1];
    A[i + 1] = A[high];
    A[high] = temp;

    return i + 1;
  }
}