package problems.sorting;

/**
 *  Time Complexity : O(nlogn)
 *  See <a href="https://www.interviewbit.com/tutorial/merge-sort-algorithm/">Recursive Merge Sort</a>
 */
public class MergeSortRecursive implements Sort {

  public static void main(String[] args) {

    int[] arr = {5, 3, 12, 1, 9, 16};

    Sort sort = new MergeSortRecursive();
    sort.sort(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

  }

  @Override
  public void sort(int[] A, int n) {

    int start = 0;
    int end = n - 1;
    if (n == 0 || n == 1) {
      return;
    }
    mergesort(A, start, end);

  }

  void mergesort(int[] A, int start, int end) {

    if (start >= end) {
      return;
    }

    int mid = (start + end) / 2;
    mergesort(A, start, mid);
    mergesort(A, mid + 1, end);
    merge(A, start, mid, end);


  }

  void merge(int[] A, int start, int mid, int end) {

    int n_left = mid - start + 1;
    int n_right = end - mid;
    int p = start;
    int left[] = new int[n_left];
    int right[] = new int[n_right];

    for (int i = 0; i < n_left; i++) {
      left[i] = A[start + i];
    }

    for (int j = 0; j < n_right; j++) {
      right[j] = A[mid + 1 + j];
    }

    int left_p = 0;
    int right_p = 0;

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
