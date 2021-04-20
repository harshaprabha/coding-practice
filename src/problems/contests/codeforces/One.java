package problems.contests.codeforces;

import java.io.PrintWriter;

import java.util.Scanner;

public class One {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    solution(in, out);
    in.close();
    out.close();
  }

  static int count = 0;

  public static void solution(Scanner in, PrintWriter out) {
    //type = 0 (number of test cases known), 1 (only 1 test case), 2 (number of test cases unknown)
    int T = 0, type = 0;
    if (type == 0) {
      T = Integer.parseInt(in.nextLine());
    } else if (type == 1) {
      T = 1;
    }
    for (int t = 0; t < T; t++) {
      algo(in, out);
    }
  }


  static void mergeSort(int start, int end, int[] arr) {
    if (start >= end) {
      return;
    }

    int mid = (start + end) / 2;
    mergeSort(start, mid, arr);
    mergeSort(mid + 1, end, arr);
    merge(start, mid, end, arr);
  }

  static void merge(int start, int mid, int end, int[] arr) {
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


  public static void algo(Scanner in, PrintWriter out) {
    int N = in.nextInt();
    int[] A = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = in.nextInt();
    }
    mergeSort(0, N - 1, A);
    int max = N * (N - 1) / 2;
    if (count <= max - 1) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }

  }
}

