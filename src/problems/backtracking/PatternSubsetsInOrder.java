package problems.backtracking;

import java.util.ArrayList;

public class PatternSubsetsInOrder {

  static ArrayList<String> result = new ArrayList<>();

  public static void main(String[] args) {
    String str = "abc";
    for (int j = 1; j <= str.length(); j++) {
      String subString = "";
      for(int i=0;i<str.length();i++)
      {
        int end = i + j;
        if (end > str.length()) {
          String before = str.substring(i);
          String after = str.substring(0, end - before.length()-2);
          subString = before + after;
        } else {
          subString = str.substring(i, end);
        }
        System.out.println(subString);
      }

    }

    System.out.println(result);
  }

  static void patternSubSets(String str, int i, int l, String temp) {

    if (i >= str.length()) {
      return;
    }

    if (temp.length() == l) {
      result.add(temp);
      return;
    }

    String subString = "";
    int end = i + l;
    if (end > str.length()) {
      String before = str.substring(i);
      String after = str.substring(0, end - before.length());
      subString = before + after;
    } else {
      subString = str.substring(i, end);
    }
    patternSubSets(str, i + 1, l, temp + subString);


  }





}
