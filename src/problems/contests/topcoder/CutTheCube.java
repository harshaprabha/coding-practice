package problems.contests.topcoder;

public class CutTheCube {

  public static void main(String[] args) {

  }


  public int findWinner(int L, int B, int H) {

    int winner = 2;
    while (L >= 1 && B >= 1 && H >= 1) {
      if (L <= 1 && B <= 1 && H <= 1) {
        break;
      }
      int min = Math.min(L, Math.min(B, H));
      L = L - min;
      B = B - min;
      H = H - min;
      if (winner == 2) {
        winner = 1;
      } else {
        winner = 2;
      }

    }

    return winner;

  }

}
