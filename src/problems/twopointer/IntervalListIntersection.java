package problems.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntervalListIntersection {

  public static void main(String[] args) {

     int[] a={100};
    List<Integer> list= Arrays.stream(a).boxed().collect(Collectors.toList());
    list.remove(100);
//    int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
//    int[][] B = {};
////    int[][] A = {{0, 1},{2,3}};
////    int[][] B = {{1, 2},{3,4}};
//    System.out.println(new IntervalListIntersection().intervalIntersection(A, B));

  }

  public int[][] intervalIntersection(int[][] A, int[][] B) {
    List<int[]> result = new ArrayList<>();
    int alen = A.length;
    int blen = B.length;
    int a = 0;
    int b = 0;

    if (alen == 0 && blen == 0) {
      return result.toArray(new int[result.size()][]);
    } else if (alen == 0 || blen == 0) {
      return result.toArray(new int[result.size()][]);
    }

    while (a < alen && b < blen) {
      int x = Math.max(A[a][0], B[b][0]);
      int y = Math.min(A[a][1], B[b][1]);

      if (x <= y)  // if overlaps
      {
        result.add(new int[]{x, y});
      }

      if (A[a][1] <= B[b][1]) {
        a++;
      } else {
        b++;
      }

    }

    return result.toArray(new int[result.size()][]);


  }

}
