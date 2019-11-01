package problems.sorting;

/**
 * Time Complexity : O(nlogn)
 */

public class QuickSortRecursive implements Sort {

  public static void main(String[] args) {
    int[] arr = {9, 4, 6, 2, 1, 11, 8, 0, -8};

    Sort sort = new QuickSortRecursive();
    sort.sort(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  @Override
  public void sort(int[] A, int n) {
    quickSort(A, 0, n - 1);

  }

  void quickSort(int[] A, int low, int high) {
    if (low > high) {
      return;
    }
    int pivot = partitionArray(A, low, high);
    quickSort(A, low, pivot - 1);
    quickSort(A, pivot + 1, high);

  }


  int partitionArray(int[] A, int low, int high) {
    int pivot_i = high;
    int pivot = A[high];
    high = high - 1;

    while (low <= high) {
      while (low <= high && A[low] < pivot) {
        low++;
      }
      while (low <= high && A[high] > pivot) {
        high--;
      }

      if (low <= high) {
        int temp = A[low];
        A[low] = A[high];
        A[high] = temp;
        low++;
        high--;
      }


    }
    int temp = A[low];
    A[low] = A[pivot_i];
    A[pivot_i] = temp;

    return low;
  }
}
