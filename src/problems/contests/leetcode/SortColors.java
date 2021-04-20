package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SortColors {

  public static void main(String[] args) {
    int A[] = {0,1,1,2, 0, 2, 1,2,2,2,0,0,0,1,1,1};
    new SortColors().sortColors(A);
    for(int i=0;i<A.length;i++)
    System.out.print (A[i]+ " ");

    ArrayList<Integer> ll= new ArrayList<>();


  }

  public void sortColors(int[] nums) {

    // One pass solution with three pointers
    int n = nums.length;
    int i = 0, j = 0, k = n - 1;

    // go to next non-zero number
    while (i < n && nums[i] == 0) {
      i++;
    }
    // go to next non 2 number from right
    while (k >= 0 && nums[k] ==2) {
      k--;
    }




    while (i < n && j < n && k >= 0) {
      if (nums[j] == 2 && k>j && k >= 0) {
        nums[j] = nums[k];
        nums[k] = 2;
        k--;
        // go to next non 2 number from right
        while (k >= 0 && nums[k] ==2) {
          k--;
        }


      }

      if (nums[j] == 1 && i>j && i < n) {
        nums[j] = nums[i];
        nums[i] = 1;
        i++;
        // go to next non-zero number
        while (i < n && nums[i] == 0) {
          i++;
        }

      }

      if (nums[j] == 0 && i<j && i < n) {
        nums[j] = nums[i];
        nums[i] = 0;
        i++;
        // go to next non-zero number
        while (i < n && nums[i] == 0) {
          i++;
        }

      }

      j++;


    }

  }


}
