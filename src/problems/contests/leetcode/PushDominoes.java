package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PushDominoes {

  public static void main(String[] args) {

    System.out.println(new PushDominoes().pushDominoes("L.L.R..R..L.R"));

  }

  public String pushDominoes(String dominoes) {

    int n = dominoes.length();
    char[] arr = dominoes.toCharArray();

    int low = 0;
    int high = -1;

    for (low = 0; low < n; ) {

      Character ch = arr[low];

      if (ch == '.') { // case .
        low++;

      } else if (ch == 'L') { // case L

        int j = low - 1;
        while (j >= 0 && arr[j] == '.') {
          arr[j] = 'L';
          j--;
        }

        low++;


      } else // case - R
      {

        // Find if R exists next before L
        int rpointer = low + 1;
        int lpointer = -1;
        while (rpointer < n && arr[rpointer] != 'R') {
          if (arr[rpointer] == 'L') {
            lpointer = rpointer;
            break;
          }
          rpointer++;
        }

        if (lpointer != -1) // found L
        {

          int left = low;
          int right = lpointer;

          while (left < n && right < n && left < right) {
            arr[left] = 'R';
            left++;
            arr[right] = 'L';
            right--;
          }

          low = lpointer + 1;

        } else  // found R
        {

          for (int setR = low + 1; setR < rpointer; setR++) {
            arr[setR] = 'R';
          }

          low = rpointer;
        }

      }
    }

    return new String(arr);


  }

}
