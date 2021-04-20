package problems.sorting;

import java.util.Arrays;

public class SortVersions {

  public static void main(String[] args) {

    String[] arr = {"1.1.0", "1.1.1", "0.1.3", "0.1.4"};

    Arrays.sort(arr, (a, b) -> {

      String[] first = a.split("\\.");
      String[] second = b.split("\\.");
      System.out.println(first.length);
      System.out.println(second.length);
      if (!first[0].equals(second[0])) {
        return Integer.valueOf(first[0]) - Integer.valueOf(second[0]);
      } else if (!first[1].equals(second[1])) {
        return Integer.valueOf(first[1]) - Integer.valueOf(second[1]);
      }
      return Integer.valueOf(first[2]) - Integer.valueOf(second[2]);

    });

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }

  }


}
