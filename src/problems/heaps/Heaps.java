package problems.heaps;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Heaps {

  public static void main(String[] args) {
    int A[] = {9, 2, 31, 4, 5, 11, 23};
    int n = A.length;

    //build max heap
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify_up(A, i, n);
    }

    TreeMap<Integer,Integer> tmap= new TreeMap<>((a,b)->b-a);

    TreeMap<int[],Integer> temap= new TreeMap<>((a,b)->b[0]-a[0]);


    //sort
    heapsort(A);

    for (int ele : A
    ) {
      System.out.println(ele);

    }
  }

  public static void heapify_up(int[] A, int i, int n) {

    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;

    if (left < n && A[left] > A[largest]) {
      largest = left;
    }
    if (right < n && A[right] > A[largest]) {
      largest = right;
    }

    if (largest != i) {
      int temp = A[largest];
      A[largest] = A[i];
      A[i] = temp;

      heapify_up(A, largest, n);
    }
  }

  public static void heapsort(int[] A) {

    for (int i = A.length - 1; i > 0; i--) {
      int temp = A[0];
      A[0] = A[i];
      A[i] = temp;
      heapify_up(A, 0, i);

    }

  }

}
