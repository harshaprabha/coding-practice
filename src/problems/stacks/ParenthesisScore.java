package problems.stacks;

import java.util.Stack;

public class ParenthesisScore {

  public static void main(String[] args) {
    System.out.println(new ParenthesisScore().scoreOfParentheses("(()())"));
  }

  public int scoreOfParentheses(String S) {

    int n = S.length();
    Stack<Character> stack = new Stack<>();
    int score = 0;

    for (int i = 0; i < n; i++) {

      if (S.charAt(i) == ')') {
        int local_score = 0;
        if (S.charAt(i - 1) == '(')  // prev element is opne
        {
          local_score = 1;
          stack.pop();
        } else {
          while (!stack.isEmpty() && stack.peek() != '(') {
            local_score += (stack.pop() - '0');
          }
          // checkout open braces
          char open = stack.pop();
          local_score = 2 * local_score;
          //  System.out.println(local_score);

        }
        //  System.out.println((char)(local_score +'0'));
        stack.push((char) (local_score + '0'));
      } else {
        stack.push(S.charAt(i)); // push open braces
      }
    }

    while (!stack.isEmpty()) {
      char v = stack.pop();
      if (v >= '0' && v <= '9') {
        score += (v - '0');
      }
    }

    return score;

  }


}
