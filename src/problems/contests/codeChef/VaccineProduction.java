package problems.contests.codeChef;

import java.util.Scanner;

public class VaccineProduction {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String inp = in.nextLine();
    String[] token = inp.split(" ");
    int P = Integer.parseInt(token[4]);
    int D1 = Integer.parseInt(token[0]);
    int V1 = Integer.parseInt(token[1]);
    int D2 = Integer.parseInt(token[2]);
    int V2 = Integer.parseInt(token[3]);

    int ans = Math.min(D1, D2) - 1; // initial days
    int V = V1 + V2;

    int minV = D2 < D1 ? V2 : V1;

    for (int i = Math.min(D1, D2); i < Math.max(D1, D2); i++) {
      P = P - minV;
      ans++;
      if (P <= 0) {
        break;
      }
    }

    if (P > 0) {
      if (P % V == 0) {
        ans += P / V;
      } else {
        ans += (P / V) + 1;
      }

    }

    System.out.println(ans);

  }

}
