package problems.bitManipulation;

/**
 * Problem Statement : https://www.interviewbit.com/problems/reverse-bits/
 */
public class ReverseBits {

  public static void main(String[] args) {

    ReverseBits reverseBits = new ReverseBits();
    System.out.println(reverseBits.reverse(3));
    System.out.println(reverseBits.reverseBitsUsingXOR(3));
    System.out.println(reverseBits.reverseWithBitOps(3));
  }

  // Method 1 - 2*O(32)
  public long reverse(long a) {

    String reversedBit = "";
    long result = 0;

    if (a == 0)
      return 0;

    // Convert number to bits and reverse
    while (a != 0) {
      int lsb = (a & 1) == 0 ? 0 : 1;
      reversedBit += lsb;
      a = a >> 1;
    }

    int n = reversedBit.length();
    int k = 32 - n;
    String zeros = "";

    // Add zero bits to make the length 32
    while (k > 0) {
      zeros += "0";
      k--;
    }

    reversedBit += zeros;
    n = reversedBit.length();

    // Convert binary to decimal
    int p = 0;
    for (int i = n - 1; i >= 0; i--) {
      int bit = reversedBit.charAt(i) - '0';
      result += (bit * Math.pow(2, p));
      p++;
    }

    return result;

  }


  // Method 2 - Using XOR - 2*O(32)
  public long reverseBitsUsingXOR(long a) {

    String numberInBits = "";
    long result = 0;

    // Convert number to bits
    while (a != 0) {
      int lsb = (a & 1) == 0 ? 0 : 1;
      numberInBits = lsb + numberInBits;
      a = a >> 1;
    }

    int n = numberInBits.length();
    int k = 32 - n;
    String zeros = "";

    // Add zero bits to make the length 32
    while (k > 0) {
      zeros += "0";
      k--;
    }
    numberInBits = zeros + numberInBits;


    int low = 0;
    int high = 31;
    char[] bitsArray = numberInBits.toCharArray();

    // Use XOR to swap the bits : Swap only if both bits are different
    while (low <= high) {
      int lowBit = bitsArray[low] - '0';
      int highBit = bitsArray[high] - '0';

      if ((lowBit ^ highBit) == 1) {
        char temp = bitsArray[low];
        bitsArray[low] = bitsArray[high];
        bitsArray[high] = temp;
      }
      low++;
      high--;


    }

    // Convert binary to decimal
    int p = 0;
    for (int i = bitsArray.length - 1; i >= 0; i--) {
      int bit = bitsArray[i] - '0';
      result += (bit * Math.pow(2, p));
      p++;
    }


    return result;

  }

  // Method 3 - O(32)
  public long reverseWithBitOps(long A) {
    long rev = 0;
    
    for (int i = 0; i < 32; i++) {
      rev = rev << 1;
      if ((A & (1 << i)) != 0)
        rev |= 1;
    }
    return rev;
  }


}
