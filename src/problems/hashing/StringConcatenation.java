package problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import sun.java2d.xr.MutableInteger;

public class StringConcatenation {

  public static void main(String[] args) {
    System.out.println(new StringConcatenation()
        .findSubstring("barfoobarfoo", Arrays.asList("foo", "bar")));
  }

  public ArrayList<Integer> findSubstring(String A, final List<String> B) {

    ArrayList<Integer> result = new ArrayList<Integer>();
    Map<String, Integer> map = new HashMap<>();

    int N = B.size();
    if (N < 1) {
      return result;
    }

    int l = B.get(0).length();

    //Initialize map
    for (int m = 0; m < N; m++) {
      if (!map.containsKey(B.get(m))) {
        map.put(B.get(m), 1);
      } else {
        int c = map.get(B.get(m));
        map.put(B.get(m), c + 1);
      }
    }

    HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
    tempMap.putAll(map);

    int count = 0;
    int startIndex = 0;

    boolean start = false;

    for (int i = 0; i <= A.length() - l; ) {

      String sub = A.substring(i, i + l);
      if (tempMap.containsKey(sub)) {
        if (!start) {
          start = true;
          startIndex = i;
        }
        count++;
        int v = tempMap.get(sub);

        if (v != 0) {
          //update map
          if (v - 1 == 0) {
            tempMap.remove(sub);
          } else {
            tempMap.put(sub, v - 1);
          }
        }

        i = i + l;
      } else {
        if (count > 0) {
          i = startIndex + 1;
        } else {
          i = i + 1;
        }
        start = false;
        tempMap = new HashMap<String, Integer>();
        tempMap.putAll(map);
        count = 0;
      }

      if (count == N) {
        i = startIndex + 1;
        start = false;
        result.add(startIndex);
        tempMap = new HashMap<String, Integer>();
        tempMap.putAll(map);
        count = 0;
      }

    }//for

    return result;

  }
}
