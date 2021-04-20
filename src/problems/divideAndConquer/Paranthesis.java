package problems.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class Paranthesis {

  List<Integer> result = new ArrayList<>();

  public static void main(String[] args) {
    System.out.println(new Paranthesis().diffWaysToCompute("2*3-4*5"));
  }

  public List<Integer> diffWaysToCompute(String input) {

    int n = input.length();
    int i=0;
    for(i=0;i<n;i++)
      if(!Character.isDigit(input.charAt(i)))
        break;

    if(i==n)
    {
      result.add(Integer.parseInt(input));
      return result;
    }

    countWays(0, n - 1, input, "");
    return result;
  }


  List<Integer> countWays(int left, int right, String input, String operandString) {

    List<Integer> operand = new ArrayList<>();

    String operandValue = "";
    for (int i = left; i <= right; i++) {

      if (input.charAt(i) == '-' || input.charAt(i) == '+' || input.charAt(i) == '*') {
        List<Integer> lefthand = countWays(left, i - 1, input, input.substring(left, i));
        List<Integer> righthand = countWays(i + 1, right, input, input.substring(i + 1, right + 1));

        // come up with all possible values
        for (int l : lefthand) {
          for (int r : righthand) {
            switch (input.charAt(i)) {
              case '-':
                operand.add(l - r);
                break;
              case '+':
                operand.add(l + r);
                break;
              case '*':
                operand.add(l * r);
                break;
            }

          }//for
        }

        System.out.println(operand.size());
        if (left == 0 && right == input.length() - 1) {
          result.addAll(operand);
          operand = new ArrayList<>();
        }


      } else {
        operandValue += input.charAt(i);
      }

    }//for

    if (operandValue.equals(operandString)) {
      operand.add(Integer.valueOf(operandString));
      return operand;
    }

    return operand;

  }


}
