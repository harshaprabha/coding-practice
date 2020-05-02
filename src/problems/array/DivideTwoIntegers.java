package problems.array;

public class DivideTwoIntegers {

  public static void main(String[] args) {
    System.out.println(new DivideTwoIntegers().divide(-2147483648,-1));
  }

  public int divide(int dividend, int divisor) {

    System.out.println(Integer.MIN_VALUE);
    System.out.println(Long.MIN_VALUE);
    int sign=-1;

    if((dividend<0 && divisor<0) || (dividend>0 && divisor>0))
      sign=1;

    long divi=Long.valueOf(dividend);
    divi=Math.abs(divi);
    long sor=Long.valueOf(divisor);
    sor=Math.abs(divisor);

    long c=1;
    long sum=sor;
    while(sum<=divi){
      sum+=sor;
      c++;
    }
    if(c-1>Integer.MAX_VALUE || c-1<Integer.MIN_VALUE)
      return Integer.MAX_VALUE;

    return sign*(int)(c-1);


  }

}
