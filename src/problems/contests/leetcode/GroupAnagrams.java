package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {


  public static void main(String[] args) {
     String[] strs={"eat","tea","tan","ate","nat","bat"};
    System.out.println(new GroupAnagrams().groupAnagrams(strs));
  }


  public List<List<String>> groupAnagrams(String[] strs) {

    Map<String,List<String>> hmap= new HashMap<>();


    for(int i=0;i<strs.length;i++){

      char[] arr=strs[i].toCharArray();
      Arrays.sort(arr);

      String key= String.valueOf(arr.toString());
      //Key not there
      if(hmap.get(key)==null)
      {
        List<String> list= new ArrayList<>();
        list.add(strs[i]);
        hmap.put(key,list);
      }
      else
      {
        List<String> words= hmap.get(key);
        words.add(strs[i]);
        hmap.put(key,words);
      }

    }//for

    List<List<String>> result = new ArrayList<>();

    for(Map.Entry<String,List<String>> entry:hmap.entrySet()){
      result.add(entry.getValue());
    }

    return result;

  }

}
