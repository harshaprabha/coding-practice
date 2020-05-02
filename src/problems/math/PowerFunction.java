package problems.math;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/implement-power-function/">
 * Power Function</a>
 * <p>Time Complexity - O(logn) </p>
 *
 * @author Harsha Prabha E
 */
public class PowerFunction {


  public static void main(String[] args) {
   // System.out.println(pow(-1, 1, 20));
    System.out.println(new PowerFunction().pow2(3,5,1,1));
  }

  public static int pow(int x, int n, int d) {
    long res = 1;
    long a = x;
    a = a % d;

    while (n > 0) {
      if (n % 2 == 1) {
        res = (res * a);
      }

      n = n >> 1;
      a = (a * a) % d;

    }
    if (res >= 0) {
      return (int) res % d;
    }
    return (d + (int) res);
  }


  public int pow2(int A, int B, int C,long result)
  {

    if(B==1)
      return (int)result;

    if(B==0)
      return 1;

    int r=1;

    if(B%2==1)
     r=r*A;

    r=A*A;

    B=B/2;
    result=pow2(r,B,C,r);
    return (int)result;

  }
}

