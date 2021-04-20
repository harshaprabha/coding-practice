package lld.Chess;

import java.util.*;

public class test {

    public static void main(String[] args) {

    }
    public int[] frequencySort(int[] nums) {
        int n= nums.length;
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);
        }


       Collections.sort(new ArrayList<>(), new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return 0;
           }
       });
        return nums;

    }

}
