package problems.twopointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BoatsToSave {

  public static void main(String[] args) {
    int A[]={3,2,2,1};
    int limit=5;
    System.out.println(new BoatsToSave().numRescueBoats(A,limit));
  }

  public int numRescueBoats(int[] people, int limit) {
    int n= people.length;

    List<Integer> list= Arrays.stream(people).boxed().collect(Collectors.toList());
    Collections.sort(list);
    int[] count= new int[limit+1];

    int min=0;
    for(int i=0;i<n;i++){
      count[people[i]]++;
    }

    for(int i=0;i<n;i++){

      count[people[i]]--;
      list.remove(Integer.valueOf(people[i]));

      if(count[limit-people[i]]!=0)
      {
        count[limit-people[i]]--;
        list.remove(Integer.valueOf(limit-people[i]));
        min++;
      }
      else
      {
        int ins= Collections.binarySearch(list,limit-people[i]);
        list.remove(Integer.valueOf(list.get(ins)));
        count[list.get(ins)]--;
      }

    }

    return min;

  }

}
