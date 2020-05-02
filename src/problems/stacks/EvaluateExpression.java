package problems.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class EvaluateExpression {

  public static void main(String[] args) {
    ArrayList<String> Arr = new ArrayList<String>(Arrays.asList("2", "2", "/"));
    System.out.println(new EvaluateExpression().evalRPN(Arr));
  }

  public int evalRPN(ArrayList<String> Arr) {

    int n = Arr.size();
    PriorityQueue<Integer> pq= new PriorityQueue<>();
    pq.add(1);

    if (n == 0) {
      return 0;
    }

    Stack<String> stack = new Stack<>();

    stack.push(Arr.get(0));
    int A = 0;
    int B = 0;
    int result = 0;
    for (int i = 1; i < n; i++) {

      String op = Arr.get(i);
      if (isOperator(op)) {
        if (!stack.isEmpty()) {
          B = Integer.parseInt(stack.pop());
        }

        if (!stack.isEmpty()) {
          A = Integer.parseInt(stack.pop());
        }
        switch (op) {
          case "+":
            result = A + B;
            break;
          case "-":
            result = A - B;
            break;
          case "*":
            result = A * B;
            break;
          case "/":
            result = A / B;
            break;
        }

        stack.push(String.valueOf(result));
      } else {
        stack.push(Arr.get(i));
      }


    }//for

    return result != 0 ? result : Integer.parseInt(stack.peek());
  }


  boolean isOperator(String op) {
    return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
  }

}
