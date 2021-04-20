package problems.contests.codeforces;

import java.util.Scanner;

public class FashionabLee {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());

    while (t > 0) {
      int n = Integer.parseInt(sc.nextLine());

      double angle = 360D / n;
      int i = 2;
      double prod = 1;

      while (i <= n && prod < 180D) {
        prod = angle * i;
        i++;
      }
      if (prod == 180D) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
      t--;
    }
  }

}
