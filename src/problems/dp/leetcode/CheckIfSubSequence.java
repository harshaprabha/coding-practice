package problems.dp.leetcode;

public class CheckIfSubSequence {

  public static void main(String[] args) {
    System.out.println(new CheckIfSubSequence().isSubsequence("abc", "ahbgdc"));

  }

  public boolean isSubsequence(String s, String t) {

//    int dp[][]= new int[s.length()+1][t.length()+1];
//
//    for(int i=1;i<=s.length();i++)
//    {
//      for(int j=1;j<=t.length();j++){
//        if(s.charAt(i-1)==t.charAt(j-1))
//          dp[i][j]=1+dp[i-1][j-1];
//        else
//          dp[i][j]=dp[i][j-1]+dp[i-1][j];
//      }
//    }
    //System.out.println(isSub(0,0,s,t));

    // return dp[s.length()][t.length()]==s.length()?true:false;
    return isSub(0, 0, s, t) == s.length() ? true : false;

  }

  int isSub(int i, int j, String s, String t) {

    int count = 0;

    if (i >= s.length() || j >= t.length()) {
      return 0;
    }

    if (s.charAt(i) == t.charAt(j)) {
      count = 1 + isSub(i + 1, j + 1, s, t);
    } else {
      count = isSub(i, j + 1, s, t) + isSub(i + 1, j, s, t);
    }
    System.out.println(count);
    return count;


  }


}
