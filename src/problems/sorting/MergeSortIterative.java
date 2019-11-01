package problems.sorting;

/**
 * Time Complexity : O(nlogn) See <a href="https://www.interviewbit.com/tutorial/merge-sort-algorithm/">Iterative
 * Merge Sort</a>
 */
public class MergeSortIterative implements Sort {

  public static void main(String[] args) {
    int[] arr = {9, 4, 6, 2, 1, 11, 8};

    Sort sort = new MergeSortIterative();
    sort.sort(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  @Override
  public void sort(int[] A, int n) {

    if (n == 1 || n == 0) {
      return;
    }

    for (int size = 1; size <= n; size = size * 2) {

      for (int start_i = 0, start_j = size; start_i <= n - 1; ) {
        int start = start_i;
        int end = (start_j + (size - 1)) >= n ? n - 1 : (start_j + (size - 1));
        int mid = (start + end) / 2;
        merge(A, start, mid, end);

        start_i = end + 1;
        start_j = (start_i + size) >= n ? start_i : (start_i + size);
      }

    }


  }


  void merge(int[] A, int start, int mid, int end) {

    int n_left = mid - start + 1;
    int n_right = end - mid;
    int p = start;
    int left_p = 0;
    int right_p = 0;

    int left[] = new int[n_left];
    int right[] = new int[n_right];

    for (int i = 0; i < n_left; i++) {
      left[i] = A[start + i];
    }

    for (int j = 0; j < n_right; j++) {
      right[j] = A[mid + 1 + j];
    }

    while (left_p < n_left && right_p < n_right) {
      if (left[left_p] <= right[right_p]) {
        A[p] = left[left_p];
        p++;
        left_p++;
      } else {
        A[p] = right[right_p];
        p++;
        right_p++;

      }

    }//while

    while (left_p < n_left) {
      A[p] = left[left_p];
      p++;
      left_p++;
    }

    while (right_p < n_right) {
      A[p] = right[right_p];
      p++;
      right_p++;
    }

  }
}
