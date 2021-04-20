package problems.contests.codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AccurateLee {

  static List<String> result;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());

    while (t > 0) {
      int n = Integer.parseInt(sc.nextLine());
      String line = sc.nextLine();
      result = new ArrayList<>();
      new AccurateLee().generateResults(line);
      Collections.sort(result);
      System.out.println(result.size() == 0 ? line : result.get(0));
      t--;
    }
  }


  void generateResults(String str) {

    for (int j = 0; j < str.length(); j++) {
      // for all pairs
      if (j + 1 < str.length() && str.charAt(j) == '1' && str.charAt(j + 1) == '0') { // pair exists
        generateResults(str); // skip pair
        generateResults(str.substring(0, j + 1) + str.substring(j + 2)); // delete 0
        generateResults(str.substring(0, j - 1) + str.substring(j + 1)); // delete 1
      }
    }
    // no more pairs left
    result.add(str);

  }


}
