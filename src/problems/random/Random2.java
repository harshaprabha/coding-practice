package problems.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import problems.sorting.BSearch;

public class Random2 {


    Map<Integer,List<Float>> map;
    public Random2(int[] nums) {
      map=new HashMap<>();
      for(int i=0;i<nums.length;i++)
      {
        if(map.get(nums[i])==null)
        {
          List<Float> arr= new ArrayList<>();
          arr.add((float)i);
          map.put(nums[i],arr);
        }else
        {
          List<Float> list= map.get(nums[i]);
          list.add((float)i);
          map.put(nums[i],list);
        }
      }//for

    }


    public int pick(int target) {
      Random rand= new Random();
      List<Float> list= map.get(target);
      float r= rand.nextFloat()*list.get(list.size()-1);
      int index= Collections.binarySearch(list,r);
      index=index<0?-index-1:index;
      return Math.round(list.get(index));
    }

  public static void main(String[] args) {


  }

}
