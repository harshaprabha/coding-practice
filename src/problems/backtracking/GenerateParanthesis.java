package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateParanthesis {

  public static void main(String[] args) {
    System.out.println(new GenerateParanthesis().generateParenthesis(1));

  }

  ArrayList<String> result = new ArrayList<String>();

  public ArrayList<String> generateParenthesis(int n) {
    if (n == 0) {
      return result;
    }

    backtrack(n, n, n, "");
    return result;

  }

  public void backtrack(int open, int closed, int n, String s) {

    if (open == 0 && closed == 0) {
      result.add(s);
    }
    if (open > 0) {
      backtrack(open - 1, closed, n, s + "(");
      //sb.deleteCharAt(sb.length()-1);
    }
    if (open > closed) {
      //sb.append(")");
      backtrack(open, closed - 1, n, s + ")");
      //sb.deleteCharAt(sb.length()-1);
    }
    ArrayList<ArrayList<String>> r = new ArrayList<ArrayList<String>>();


  }


}
