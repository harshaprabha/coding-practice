package problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

  public static void main(String[] args) {
    System.out
        .println(new Anagrams().anagrams(Arrays.asList("cat", "tac", "not", "mmm", "ton", "act")));
  }

  public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
    int n = A.size();
    Map<Integer, ArrayList<Integer>> resultMap = new HashMap<>();
    Map<String, Integer> wordsMap = new HashMap<String, Integer>();

    for (int i = 0; i < n; i++) {
      char[] arr = A.get(i).toCharArray();
      Arrays.sort(arr);
      String key = String.valueOf(arr);

      if (!wordsMap.containsKey(key)) {
        wordsMap.put(key, i);

        // update result as well
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(i + 1);
        resultMap.put(i, list1);

      } else {
        int index = wordsMap.get(key);
        ArrayList<Integer> list = resultMap.get(index);
        list.add(i + 1);
        resultMap.put(index, list);

      }
    }

    //
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    for (Map.Entry entry : resultMap.entrySet()) {
      result.add((ArrayList<Integer>) entry.getValue());

    }

    return result;

  }


}
