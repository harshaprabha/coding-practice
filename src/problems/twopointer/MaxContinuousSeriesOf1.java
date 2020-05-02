package problems.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousSeriesOf1 {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0,1,1,1));
    new MaxContinuousSeriesOf1().maxone(A,0);

  }
  public ArrayList<Integer> maxone(ArrayList<Integer> A, int M) {

    int max=Integer.MIN_VALUE;
    int n= A.size();
    int zeroes=0;
    int[] zeroCount= new int[n];
    Arrays.fill(zeroCount,0);
    zeroCount[n-1]=A.get(n-1)==0?1:0;
    for(int i=n-2,j=0;i>=0;i--)
    {
      if(A.get(i)==0)
        zeroes++;
      zeroCount[i]=zeroCount[i+1]+A.get(i)==0?1:0;
    }

    int w=0;
    int c=M;
    int wsize=0;
    int s=0;
    int e=0;

    ArrayList<Integer> res= new ArrayList<Integer>();
    if(M>=zeroes)
    {
      for(int p=0;p<n;p++){
        res.add(p);
      }

      return res;

    }// ret

    for(int k=0;k<n;k++){
      w=k;

      if(zeroCount[k]>M){

        if(M==0)
        {
          if(A.get(w)==0){

            w++;k=w;}
          else
            w++;
        }
        else{
          while(w<n)
          {
            if(c>0 && A.get(w)==0)
            {
              c--;
              w++;
            }

          }
        }

        wsize=w-k;

      }
      else if(zeroCount[k]==M)
      {
        wsize=n-k;

      }
      else
        break;


      if(max<wsize)
      {
        max=wsize;
        s=k;
        e=w;
      }

    }




    for(int p=s;p<=e;p++){
      res.add(p);
    }

    return res;



  }

}
