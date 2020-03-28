package problems.contests.topcoder;

import java.util.ArrayList;

public class EvenRoute {

  public static void main(String[] args) {
    int x[] = {-1, -1, 1, 1};
    int y[] = {-1, 1, 1, -1};
    int parity = 0;
    System.out.println(new EvenRoute().isItPossible(x, y, parity));
  }

  class Pair {

    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static ArrayList<ArrayList<Pair>> permutations = new ArrayList<>();

  String isItPossible(int[] x, int[] y, int wantedParity) {
    ArrayList<Pair> arr = new ArrayList<>();
    for (int i = 0; i < x.length; i++) {
      arr.add(new Pair(x[i], y[i]));
    }

    getPairPermutations(arr, 0, x.length, new ArrayList<>());

    System.out.println(permutations);

    for (int k = 0; k < permutations.size(); k++) {
      ArrayList<Pair> pairs = permutations.get(k);
      pairs.add(new Pair(0, 0));
      int steps = 0;
      for (int m = 1; m < pairs.size(); m++) {
        steps += Math
            .abs(pairs.get(m).x - pairs.get(m - 1).x + pairs.get(m).y - pairs.get(m - 1).y);

      }
      if ((wantedParity == 1 && steps % 2 != 0) || (wantedParity == 0 && steps % 2 == 0)) {
        return "CAN";
      }

    }

    return "CANNOT";
  }

  static void getPairPermutations(ArrayList<Pair> arr, int i, int n, ArrayList<Pair> temp) {

    if (i == n) {
      if (temp.size() == n) {
        permutations.add(new ArrayList<>(temp));

      }
      return;
    }

    System.out.println("harsha");

    for (int j = i; j < n; j++) {
      swap(arr, i, j);
      temp.add(arr.get(i));
      getPairPermutations(arr, i + 1, n, temp);
      temp.remove(temp.size() - 1);
      swap(arr, j, i);

    }

  }


  static void swap(ArrayList<Pair> arr, int i, int j) {
    Pair one = arr.get(i);
    Pair two = arr.get(j);
    arr.set(i, two);
    arr.set(j, one);
  }


}
