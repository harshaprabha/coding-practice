package problems.sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class CountInversions {

  public static void main(String[] args) {

    int A[] = {2, 1, 3, 1, 2};
    PriorityQueue<Integer> pq= new PriorityQueue<>();
pq.remove();
    List<String> result= new LinkedList<>();
//    ((LinkedList<String>) result).addFirst();

    System.out.println(new CountInversions().countInversions(A));
  }

  int count = 0;
  // Complete the countInversions function below.
  long countInversions(int[] arr) {

    int n = arr.length;

    mergeSort(0, n - 1, arr);
    return count;
  }


  void mergeSort(int start, int end, int[] arr) {
    if (start >= end) {
      return;
    }

    int mid = (start + end) / 2;
    mergeSort(start, mid, arr);
    mergeSort(mid + 1, end, arr);
    merge(start, mid, end, arr);
  }

  void merge(int start, int mid, int end, int[] arr) {
    int[] left = new int[mid - start + 1];
    int[] right = new int[end - mid];
    int l = 0;
    int r = 0;

    for (int i = start; i <= mid; i++) {
      left[l] = arr[i];
      l++;
    }
    for (int j = mid + 1; j <= end; j++) {
      right[r] = arr[j];
      r++;
    }

    int m = left.length;
    int n = right.length;
    int p = start;
    l = 0;
    r = 0;
    while (l < m && r < n) {
      while (l < m && r < n && left[l] <= right[r]) {
        arr[p] = left[l];
        p++;
        l++;
      }
      while (l < m && r < n && left[l] > right[r]) // inversion condition
      {
        count++;
        arr[p] = right[r];
        p++;
        r++;
      }

    }
    // handle left over
    while (l < m) {
      arr[p] = left[l];
      p++;
      l++;
      count++; // if left elements are left , then they are greater than right elements that were assigned
    }
    while (r < n) {
      arr[p] = right[r];
      p++;
      r++;
    }

  }


}
