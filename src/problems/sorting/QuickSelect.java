package problems.sorting;

public class QuickSelect implements Sort {

  public static void main(String[] args) {
    int[] arr = {1, 4, 3, 2, 7, 8, 1};

    Sort sort = new QuickSelect();
    sort.sort(arr, arr.length);


  }

  @Override
  public void sort(int[] A, int n) {
    int k = 7;
    System.out.println(quickSort(0, n - 1, A, k - 1));
  }

  int quickSort(int low, int high, int[] A, int k) {

    if (low>high) { // no single element comparison like merge sort
      return 0;
    }
    int ans=-1;
    int index = partition(low, high, A);

    if (index == k) {
      ans= A[index];
    } else if (index > k) {
      ans= quickSort(low, index - 1, A, k);
    }
    else ans= quickSort(index + 1, high, A, k);

    return ans;
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
