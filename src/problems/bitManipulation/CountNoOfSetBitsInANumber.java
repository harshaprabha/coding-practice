package problems.bitManipulation;

public class CountNoOfSetBitsInANumber {

	public static void main(String[] args) {

		CountNoOfSetBitsInANumber countNoOfSetBitsInANumber = new CountNoOfSetBitsInANumber();

		System.out.println(countNoOfSetBitsInANumber.numSetBits(999999999));
		System.out.println(countNoOfSetBitsInANumber.numSetBitsUsingBitTrick(999999999));
		System.out.println(countNoOfSetBitsInANumber.numSetBitsUsingBitOp(999999999));
	}

	// Method 1
	public int numSetBits(long a) {
		int count = 0;
		long num = 0;
		long remainder = 0;

		// Method 1 - O(logN)
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

	// Method 2
	public int numSetBitsUsingBitTrick(long a) {
		int count = 0;

		// Time complexity : O(no_of_ones)
		while (a != 0) {
			a = (a & (a - 1));
			count++;

		}
		return count;

	}

	// Method 3 : bit version of Method 1 - O(logN)
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
