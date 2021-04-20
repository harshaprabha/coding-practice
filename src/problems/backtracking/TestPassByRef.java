package problems.backtracking;

public class TestPassByRef {

  public static void main(String[] args) {
    boolean[] A= new boolean[3];
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i]+" ");
    }
    backtrack(0,A);
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i]+" ");
    }
    System.out.println();
  }


  static void backtrack(int i, boolean[] A)
  {
    if(i>=A.length)
    {
      A[i-1]=false;
      return;
    }

    A[i]=true;
    System.out.println("Entering function="+A[i]);
    backtrack(i+1,A);
    System.out.println("Exiting function="+A[i]);
  }



}
