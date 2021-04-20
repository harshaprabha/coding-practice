package problems.contests.codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Applejack {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    solution(in, out);
    in.close();
    out.close();
  }

  public static void solution(Scanner in, PrintWriter out) {
    int n = in.nextInt();
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> arr= new ArrayList<>();
    

    for (int i = 0; i < n; i++) {
      int ele = in.nextInt();
      map.put(ele, map.getOrDefault(ele, 0) + 1);
    }

    int Q = in.nextInt();
    for (int q = 0; q < Q; q++) {
      String logs = in.nextLine();
      out.println(logs);
      if (logs.charAt(0)=='+') {
        map.put((logs.charAt(2)-'0'), map.getOrDefault((logs.charAt(2)-'0'), 0) + 1);
      } else {
        map.put((logs.charAt(2)-'0'), map.getOrDefault((logs.charAt(2)-'0'), 0) - 1);
      }
      algo(in, out, map);
    }

  }

  public static void algo(Scanner in, PrintWriter out, Map<Integer, Integer> map) {

    boolean sq = false;
    boolean rect = false;
    boolean carry = false;

    for (Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() >= 4) {
        sq = true;
        int no_of_squares = entry.getValue() / 4;
        if (no_of_squares > 1) {
          rect = true;
          out.println("YES");
          break;
        }
        if (entry.getValue() - 4 >= 2) {
          carry = true;
        }

      } else if (entry.getValue() >= 2) {
        if (carry) {
          rect = true;
          out.println("YES");
        } else {
          carry = true;
        }
      }

      if (sq && rect) {
        out.println("YES");
      }

    }

    out.println("NO");


  }

}
