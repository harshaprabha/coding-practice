package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class SorTSubsetsLexicographically {

  static ArrayList<ArrayList<Character>> result = new ArrayList<>();

  public static void main(String[] args) {

    String inp = "123";

    subSets(0, inp, new ArrayList<>());
    System.out.println(result);

    /**
     * o1,o2
     * return 1 -> o2 comes before o1
     * retirn -1 ->o1 comes before o2
     *
     */
    Collections.sort(result, new Comparator<ArrayList<Character>>() {
      @Override
      public int compare(ArrayList<Character> o1, ArrayList<Character> o2) {

        Iterator<Character> itr1 = o1.iterator();
        Iterator<Character> itr2 = o2.iterator();

        while (itr1.hasNext() && itr2.hasNext()) {
          if (itr1.next() >itr2.next()) {
            return 1;
          }
        }
        return itr1.hasNext() ? 1 : -1;
      }
    });
    System.out.println(result);

  }

  static void subSets(int i, String s, ArrayList<Character> temp) {

    if (i == s.length()) {
      if (temp.size() != 0) {
        result.add(new ArrayList<>(temp));
      }
      return;
    }
    temp.add(s.charAt(i));
    subSets(i + 1, s, temp);
    temp.remove(temp.size() - 1);
    subSets(i + 1, s, temp);
  }


}
