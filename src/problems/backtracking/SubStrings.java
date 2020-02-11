package problems.backtracking;

public class SubStrings {

  public static void main(String[] args) {
    String str = "abc";

    substringRecursive(str, 1, 0);

    for (int len = 1; len <= str.length(); len++) {
      for (int i = 0; i < str.length(); i++) {

        int end = (i + len);
        end = end > str.length() ? i : end;

        if (i != end) {
          // System.out.println(str.substring(i, end));
        }

      }
    }

  }

  public static void substringRecursive(String str, int len, int start) {

    StringBuilder sb= new StringBuilder();
    sb.deleteCharAt(sb.length()-1);
    if (start > str.length()) {
      return;
    }
    int end = (start + len);
    end = end > str.length() ? start : end;
    if(start!=end)
    System.out.println(str.substring(start, end));
    for (int l = 1; l <=str.length(); l++) {
      substringRecursive(str, l, start + 1);
    }

  }




}
