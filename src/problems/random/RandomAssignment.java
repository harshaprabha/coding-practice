package problems.random;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomAssignment {


  public static void main(String[] args) {

    int i = 0;

    /**
     * Method 1
     */
    while (i <= 20) {
      int r = ThreadLocalRandom.current().nextInt(1, 100 + 1);
      System.out.println(r);
      i++;
    }
    i = 0;
    /**
     * min =5, max=10
     * Method 2
     *
     *
     * int range = maximum - minimum + 1;
     * int randomNum =  rn.nextInt(range) + minimum;
     *
     **/
    Random rand = new Random();
    while (i <= 20) {

      int r = rand.nextInt(5 + 1) + 5;
      System.out.println(r);
      i++;
    }


  }

}
