package problems.contests.leetcode;

public class PerformStringShifts {


  public static void main(String[] args) {
    int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
    System.out.println(new PerformStringShifts().stringShift("abcdefg", shift));
  }


  public String stringShift(String s, int[][] shift) {

    int dp[][] = new int[shift.length + 1][2];

    for (int i = 1; i <= shift.length; i++) {

      //not equal - subtract
      if (shift[i - 1][0] != dp[i - 1][0]) {
        int direction = dp[i - 1][1] > shift[i - 1][1] ? dp[i - 1][0] : shift[i - 1][0];
        int amt = Math.abs(dp[i - 1][1] - shift[i - 1][1]);
        dp[i][0] = direction;
        dp[i][1] = amt;

      } else {
        dp[i][0] = shift[i - 1][0];
        dp[i][1] = Math.abs(shift[i - 1][1] + dp[i - 1][1]);
      }


    }

    String result = "";

    int shifts = dp[shift.length][1] % s.length();

    if (dp[shift.length][0] == 0) {
      //left shift
      result = s.substring(shifts) + s.substring(0, shifts);

    } else {
      //right shift
      result = s.substring(s.length() - shifts) + s.substring(0, s.length() - shifts);


    }

    return result;

  }
}
