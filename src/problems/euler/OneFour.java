package problems.euler;

import java.util.HashMap;
import java.util.Map;

public class OneFour {

//  public static void main(String[] args) {
//
//    Map<Integer, Integer> primes = new HashMap<>();
//
//    for (int i = 2; i <= 20; i++) {
//      Map<Integer, Integer> primeFactors = factorize(i);
//      for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
//        primes.put(entry.getKey(),
//            Math.max(primes.getOrDefault(entry.getKey(), 0), entry.getValue()));
//      }
//    }
//
//    int prod = 1;
//    for (Map.Entry entry : primes.entrySet()) {
//      for (int k = 1; k <= (int) entry.getValue(); k++) {
//        prod *= (int) entry.getKey();
//      }
//
//    }
//
//    System.out.println(prod);
//
//
//  }
//


  public static void main(String[] args) {
int n=100;
    long sumOfSquares=(n*(n+1)*(2*n+1))/6;
    long sumOfNSqure= (n*(n+1))/2;
    long ans=sumOfNSqure*sumOfNSqure-sumOfSquares;
    System.out.println(Math.abs(ans));

  }

  static Map<Integer, Integer> factorize(int i) {

    Map<Integer, Integer> primes = new HashMap<>();

    if (i == 2 || i == 3 || i == 5 || i == 7 || i == 11 || i == 13 || i == 17 || i == 19) {
      primes.put(i, 1);
      return primes;
    }

    int factor = 2;

    while (factor * factor <= i) {
      while (i % factor == 0) {
        primes.put(factor, primes.getOrDefault(factor, 0) + 1);
        i = i / factor;
      }
      factor++;
    }

    return primes;

  }

}
