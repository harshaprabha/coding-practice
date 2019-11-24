package problems.numbers;

import java.util.ArrayList;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/prime-numbers/"> Prime
 * Numbers</a>
 * <p>Time Complexity - O(nloglogn) </p>
 *
 * @author Harsha Prabha E
 */
public class PrimeNumbers {


  public static void main(String[] args) {
    PrimeNumbers primeNumbers = new PrimeNumbers();
    ArrayList<Integer> primes = primeNumbers.sieve(10);
    primes.stream().forEach(System.out::println);

  }

  public ArrayList<Integer> sieve(int A) {
    ArrayList<Integer> result = new ArrayList<Integer>();

    if (A <= 1) {
      return result;
    }

    if (A == 2) {
      result.add(2);
      return result;
    }

    int primes[] = new int[A + 1];
    primes[0] = 0;
    primes[1] = 0;

    for (int p = 2; p < primes.length; p++) {
      primes[p] = 1;
    }

    for (int i = 2; i <= Math.sqrt(A); i++) {
      if (primes[i] == 1) {
        for (int j = 1; i * j <= A; j++) {
          primes[i * j] = 0;
        }
      }
    }

    for (int p = 2; p < primes.length; p++) {
      if (primes[p] == 1) {
        result.add(p);
      }
    }

    return result;

  }

}
