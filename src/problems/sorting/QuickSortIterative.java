package problems.sorting;

import java.util.Stack;

/**
 * Iterative Quick Sort Time Complexity : O(nlogn)
 */
public class QuickSortIterative implements Sort {

  public class QuickSortObj {

    int low;
    int high;

    QuickSortObj(int l, int h) {
      this.low = l;
      this.high = h;
    }

  }

  public static void main(String[] args) {
    int[] arr = {9, 4, 6, 2, 1, 11, 8, 0, -8};

    Sort sort = new QuickSortIterative();
    sort.sort(arr, arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  @Override
  public void sort(int[] A, int n) {

    Stack<QuickSortObj> stack = new Stack<>();

    QuickSortObj obj = new QuickSortObj(0, n - 1);
    stack.push(obj);

    while (!stack.isEmpty()) {
      QuickSortObj stackObj = stack.pop();
      if (stackObj.low <= stackObj.high) {
        int pivot = partitionArray(A, stackObj.low, stackObj.high);
        System.out.println("pivot=" + pivot);
        if (pivot - 1 > 0 && pivot - 1 < n) {
          stack.push(new QuickSortObj(stackObj.low, pivot - 1));
        }
        if (pivot + 1 > 0 && pivot + 1 < n) {
          stack.push(new QuickSortObj(pivot + 1, stackObj.high));
        }
      }

    }

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
