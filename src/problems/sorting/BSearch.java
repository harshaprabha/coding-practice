package problems.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BSearch {

  float[] aggregate;
  int N;

  public BSearch(int[] w) {

    N=w.length;
    aggregate= new float[w.length];
    aggregate[0]=w[0];

    for(int i=1;i<w.length;i++){

      aggregate[i]=aggregate[i-1]+w[i];
    }
  }

  public int pickIndex() {
    if(N==1)
      return 0;
    Random random= new Random();

    float r= random.nextFloat()*aggregate[aggregate.length-1];

    int index= Arrays.binarySearch(aggregate,r);
    index=index<0?-index-1:index;
    return index;

  }


  public static void main(String[] args) {

    int A[]={1,3};;
    BSearch bsearch= new BSearch(A);
    System.out.println(bsearch.pickIndex());
    System.out.println(bsearch.pickIndex());
    System.out.println(bsearch.pickIndex());
    System.out.println(bsearch.pickIndex());
    System.out.println(bsearch.pickIndex());



  }

}
