package problems.contests.codeChef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.codechef.com/problems/TASHIFT
 */
class ShiftTheString {

  public static void main(String[] args) {



    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();
    String A = sc.nextLine();
    String B = sc.nextLine();


    if (A.equals(B)) {
      System.out.println(0);
      sc.close();
      return;
    }
    

    if (N == 1) {
      System.out.println(0);
      return;
    }

    int jump[] = new int[N];
    jump[0] = 0;

    int j = 0;
    int max = Integer.MIN_VALUE;
    int index = 0;
    //create jump matrix
    for (int i = 1; i < N; ) {
      int k = i;
      if (A.charAt(j) == B.charAt(i)) {
        jump[i] = j + 1;
        i++;
        j++;
      } else {
        if (j != 0) {
          j = jump[j - 1];
        } else {
          jump[i] = 0;
          i++;
        }
      }//else

      if (k < N && jump[k] > max) {
        max = jump[k];
        index = k;
      }

    }//for
    if (jump[index] == 0) {
      System.out.println(0);
      sc.close();;
      return;
    }

    System.out.println(index - jump[index] + 1);
    sc.close();
    return;

  }


}
