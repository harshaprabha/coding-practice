package problems.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/intersection-of-sorted-arrays/">
 * Intersection of two sorted arrays</a>
 * <p>Time Complexity - O(n)</p>
 *
 * @author Harsha Prabha E
 */
public class Intersect {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1000));
    ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1000));
    new Intersect().intersect(A, B);
  }


  public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {

    ArrayList<Integer> out = new ArrayList<Integer>();
    int na = A.size();
    int nb = B.size();
    int ptrA = 0;
    int ptrB = 0;

    if (na == 0 || nb == 0) {
      return out;
    }

    while (ptrA < na && ptrB < nb) {
      if (A.get(ptrA).equals(B.get(ptrB))) {
        out.add(A.get(ptrA));
        ptrA++;
        ptrB++;
      } else if (A.get(ptrA) < B.get(ptrB)) {
        ptrA++;
      } else {
        ptrB++;
      }
    }

    return out;

  }

}
