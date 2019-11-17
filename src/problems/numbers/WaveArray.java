package problems.numbers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/wave-array/"> Wave
 * Array</a>
 * <p>Time Complexity - O(n) </p>
 *
 * @author Harsha Prabha E
 */
public class WaveArray {

  public static void main(String[] args) {
    WaveArray waveArray = new WaveArray();

    ArrayList<Integer> A = new ArrayList<Integer>() {{
      add(1);
      add(2);
      add(9);
      add(3);
      add(5);
    }};
    waveArray.wave(A);
    for (int i = 0; i < A.size(); i++) {
      System.out.print(A.get(i)+" ");
    }

  }


  public ArrayList<Integer> wave(ArrayList<Integer> A) {

    int n = A.size();

    if (n <= 1) {
      return A;
    }

    Collections.sort(A);

    int prev = 0;
    int next = 1;

    while (next < n) {
      int temp = A.get(prev);
      A.set(prev, A.get(next));
      A.set(next, temp);

      prev += 2;
      next += 2;

    }

    return A;


  }

}
