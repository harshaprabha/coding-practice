package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main2 {

  public static void main(String[] args) {
    int[] A={19,22,28,29,66,81,93,97};
    String S="fnfaaxha";
    System.out.println(new Main2().slowestKey(A,S));
  }

  public char slowestKey(int[] releaseTimes, String keysPressed) {
    int n= releaseTimes.length;

    Map<Character,Integer> map= new HashMap<>();
    for(int i=0;i<n;i++)
    {
      char ch=keysPressed.charAt(i);
      if(map.get(ch)==null)
      {
        int duration=releaseTimes[i];
        if(i>0)
          duration=releaseTimes[i]-releaseTimes[i-1];
        map.put(ch,duration);
      }
      else
      {
        int d= map.get(ch);
        int duration=releaseTimes[i];
        if(i>0)
          duration=releaseTimes[i]-releaseTimes[i-1];
        d=Math.max(d,duration);
        map.put(ch,d);
      }
    }


    List<Entry<Character,Integer>> list= new ArrayList<>(map.entrySet());
    Collections.sort(list,(a,b)->a.getValue()==b.getValue()?b.getKey()-a.getKey():b.getValue()-a.getValue());

    return list.get(0).getKey();

  }

}
