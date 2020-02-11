package problems.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PalindromicSubstring {

  public static void main(String[] args) {
    System.out.println(new PalindromicSubstring().partition("aaa"));

  }

  ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

  public ArrayList<ArrayList<String>> partition(String a) {

    int n = a.length();
    backtrack(a, n, new ArrayList<String>(), 0);
    return result;

  }


  public void backtrack(String A, int n, ArrayList<String> temp, int start) {

    if (start == n) {
      result.add(new ArrayList<String>(temp));
    } else {
      for (int i = start; i < n; i++) {
        String sub = A.substring(start, i + 1);
        if (isPalin(A, start, i)) {
          temp.add(sub);
          backtrack(A, n, temp, i + 1);
          temp.remove(temp.size() - 1);
        }//if

      }
    }


  }


  public boolean isPalin(String A, int start, int end) {

    while (start < end) {
      if (A.charAt(start) != A.charAt(end)) {
        return false;
      }
      start++;
      end--;

    }

    return true;

  }

}
