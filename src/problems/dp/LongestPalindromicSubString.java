package problems.dp;

public class LongestPalindromicSubString {

  public static void main(String[] args) {
    String a=new StringBuilder("geetha").reverse().toString();
    System.out.println(a);
    //System.out.println(new LongestPalindromicSubString().longestPalindrome(""));
  }
  String str = "";
  int max = 0;

  public String longestPalindrome(String s) {
    int n= s.length();

    boolean dp[][]= new boolean[n+1][n+1];
    dp[0][0]=true;
    int max=1;
    String pal="";
    for(int i=n;i>0;i--)
    {
      for(int j=n;j>=i;j--)
      {
        if(i==j)
          dp[i][j]=true;
        else
        {
          if(s.charAt(i-1)==s.charAt(j-1))
            dp[i][j]=i+1==j? true: dp[i+1][j-1];
        }

        if(dp[i][j])
        {
          if(j-i+1>max)
          {
            max=j-i+1;
            pal=s.substring(i-1,j);
          }
        }//if
      }
    }

    for (boolean[] arr : dp) {
      for(int j=0;j<=n;j++)
      System.out.print(arr[j]+" ");
      System.out.println();
    }

    return pal;

  }


  boolean findLongPalin(String s, int i, int j) {

    boolean isPalin = false;


    if (i == j) {
      return true;
    }
    if (i + 1 == j) {
      if (s.charAt(i) == s.charAt(j)) {
        return true;
      }
      return false;
    }

    if (s.charAt(i) == s.charAt(j)) {
      isPalin = findLongPalin(s, i + 1, j - 1);
    }
    else
    {
      isPalin = findLongPalin(s, i + 1, j) || findLongPalin(s, i, j - 1);

    }

    if (isPalin) {
      if (max < j - i) {
        max = j - i;
        str = s.substring(i, j + 1);

      }
    }
    return isPalin;

  }

}
