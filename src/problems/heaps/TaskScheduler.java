package problems.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class TaskScheduler {

  public static void main(String[] args) {
  }

  public String rearrangeString(String s, int K) {
    char[] inp= s.toCharArray();
    StringBuilder sb= new StringBuilder();

    if(K==0)
      return s;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < inp.length; i++) {
      map.put(inp[i], map.getOrDefault(inp[i], 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
        (a, b) -> {return a.getValue()==b.getValue()?a.getKey()-b.getKey():b.getValue() - a.getValue();}); // sort by high frequency


    pq.addAll(map.entrySet());

    Map<Character, Integer> tempList = new HashMap<>();


    // n*maxfreq - O(n*freq)
    while (!pq.isEmpty()) {
      int k = K;
      tempList = new HashMap<>();
      while (k > 0 && !pq.isEmpty()) {
        Map.Entry<Character, Integer> frequent = pq.remove();
        sb.append(frequent.getKey());
        if (frequent.getValue() - 1 > 0) { // add valid ones
          tempList.put(frequent.getKey(), frequent.getValue() - 1);
        }
        k--;
      }

      pq.addAll(tempList.entrySet());

      if(!pq.isEmpty() && k>0)  // idle case, no alphabet to assign
        return "";



    }//while

    return sb.toString();






  }

}
