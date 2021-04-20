package problems.contests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fractions {

  static List<String> result = new ArrayList<>();
  Set<String> set = new HashSet<>();

  public static void main(String[] args) {
//    System.out.println(new Fractions().simplifiedFractions(8));
//    System.out.println(result);
    ArrayList<Integer> a= new ArrayList<>();

    a.add(5,10);

    for (int i : a) {
      System.out.println(i);
    }
  }


  public List<String> simplifiedFractions(int n) {

    if (n == 1) {
      return result;
    }

    fractions(n, n);
    return result;

  }

  void fractions(int num, int deno) {
    if (num < 1 || deno < 1 || deno == 1) {
      return;
    }

    if(num==3 && deno==8)
    {
      System.out.println();
    }
    if (num != deno && num < deno && gcd(deno, num) == 1) {

      if (!set.contains(num + "/" + deno)) {
        set.add(num + "/" + deno);
        result.add(num + "/" + deno);
      }
    }
    fractions(num, deno - 1);
    fractions(num - 1, deno);

  }


  int gcd(int num, int deno) {

    if (num == 1 || deno == 1) {
      return 1;
    }
    if (deno == 0) {
      return num;
    }

    int r = num % deno;
    num=num/deno;
    return gcd(deno, r);

  }

}


