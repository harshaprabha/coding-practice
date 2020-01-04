package problems.stacks;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/simplify-directory-path/">
 * Simplified Directory Path</a>
 * <p>Time Complexity - O(n)</p>
 * <p>Space Complexity - O(n)</p>
 *
 * @author Harsha Prabha E
 */

public class SimplifiedDirectoryPath {

  public static void main(String[] args) {
    System.out
        .println(new SimplifiedDirectoryPath().simplifyPath("/./.././ykt/fuv/bjg/./qbd/./.."));

  }

  public String simplifyPath(String A) {

    int n = A.length();
    Stack<String> stack = new Stack<>();
    StringBuilder word = new StringBuilder();
    stack.push("/");
    for (int i = 1; i <= n; i++) {
      if (i != n && A.charAt(i) != '/') {
        word.append(A.charAt(i));
      } else if (i == n || A.charAt(i) == '/') {
        if (word.toString().equals("..")) {
          if (!stack.isEmpty()) {
            stack.pop();
          }
          if (!stack.isEmpty()) {
            stack.pop();
          }
        } else if (!word.toString().equals(".") && !word.toString().equals("")) {
          if (stack.isEmpty()) {
            stack.push("/");
          }
          stack.push(word.toString());
        }

        if (!stack.isEmpty() && stack.peek() != "/") {
          stack.push("/");
        }
        word = new StringBuilder();
      }

    }
    if (!stack.isEmpty() && stack.peek() == "/") {
      stack.pop();
    }

    ArrayList<String> list = new ArrayList<>(stack);
    word = new StringBuilder();
    for (String s : list
    ) {
      word.append(s);
    }

    return word.toString().isEmpty() ? "/" : word.toString();

  }

}
