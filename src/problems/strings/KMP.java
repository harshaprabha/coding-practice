package problems.strings;

import java.util.ArrayList;

public class KMP {

  public static void main(String[] args) {
    String text = "abxabcabcaby";
    String pattern = "abcaby";

    ArrayList<Integer> indices = allmatchingIndices(text, pattern);
    System.out.println(indices);
  }

  static ArrayList<Integer> allmatchingIndices(String text, String pattern) {
    ArrayList<Integer> result = new ArrayList<Integer>();

    if (pattern.length() > text.length()) {
      return result;
    }

    if (pattern.length() == text.length()) {
      if (pattern.equals(text)) {
        result.add(0);
        return result;
      } else {
        return result;
      }
    }

    //Generate Jump array for pattern string
    int max = Integer.MIN_VALUE;
    int index = -1;
    int[] jump = new int[pattern.length()];
    jump[0] = 0;

    for (int i = 1, j = 0; i < pattern.length() && j < i; ) {
      int k=i;
      // j is slow, i is fast
      if (pattern.charAt(i) == pattern.charAt(j)) {
        jump[i] = j + 1;
        i++;
        j++;
      } else {
        if (j != 0) {
          j = jump[j - 1];
        } else {
          jump[i] = 0;
          i++;
        }
      }
    }

    //Match pattern with text

    int p=0;
    for(int k=0;k<text.length();){
      if(pattern.charAt(p)!=text.charAt(k))
      {
        p=jump[p];
      }
      else
      {
        if(p==pattern.length()-1)
        {
          result.add(k-pattern.length()-1);
          p=0;
          continue;
        }
        else p++;
      }
      k++;
    }

    return result;

  }

}
