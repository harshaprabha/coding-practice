package problems.bitManipulation;

/**
 * Problem Statement 
 * See <a href="https://www.interviewbit.com/problems/number-of-1-bits/"> Count No Of 1 Bits</a> 
 */
public class CountNoOfSetBitsInANumber {

  public static void main(String[] args) {

    CountNoOfSetBitsInANumber countNoOfSetBitsInANumber = new CountNoOfSetBitsInANumber();

    System.out.println(countNoOfSetBitsInANumber.numSetBits(999999999));
    System.out.println(countNoOfSetBitsInANumber.numSetBitsUsingBitTrick(999999999));
    System.out.println(countNoOfSetBitsInANumber.numSetBitsUsingBitOp(999999999));
  }

  /**
   * Method 1 - Time complexity : O(logN)
   */
  public int numSetBits(long a) {
    int count = 0;
    long num = 0;
    long remainder = 0;

    while (a >= 2) {
      num = a / 2;
      remainder = a % 2;
      if (remainder == 1)
        count++;
      a = num;

    }
    if (a == 1)
      count++;

    return count;

  }

  /**
   * Method 2 - Time complexity : O(no_of_ones)
   */
  public int numSetBitsUsingBitTrick(long a) {
    int count = 0;

    // Time complexity : O(no_of_ones)
    while (a != 0) {
      a = (a & (a - 1));
      count++;

    }
    return count;

  }

  /**
   * Method 3 -  Time complexity : O(log N)
   */
  public int numSetBitsUsingBitOp(long a) {
    int count = 0;
    while (a > 0) {
      if ((a & 1) == 1) {
        count++;
      }
      a = a >> 1;
    }
    return count;
  }

}
