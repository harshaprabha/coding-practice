package problems.strings;

public class LongestPrefixWhichIsAlsoSuffix {

  public static void main(String[] args) {

    String str="leetcodeleet";
    String result="";
    int max=Integer.MIN_VALUE;
      int i=0;
      for(int j=i+1;j<=str.length()-1;j++)
      {
        String prefix= str.substring(i,j);
        int suffixIndex=j-i;
        if(prefix.equals(str.substring(str.length()-suffixIndex)))
        {
          if(max<suffixIndex)
          {
            result=prefix;
            max=Math.max(max,suffixIndex);
          }

        }
      }

    System.out.println(result);

  }




}
