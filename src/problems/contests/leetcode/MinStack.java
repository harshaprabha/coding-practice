package problems.contests.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;

public class MinStack {


  List<Integer> arr;
  List<Integer> min;
  Deque<Pair<Integer,Integer>> stack;


  public MinStack() {
    arr = new LinkedList<>();
    min = new LinkedList<>();
    min.add(Integer.MAX_VALUE);

  }

  public void push(int x) {
    arr.add(x);
    if(min.size()!=0)
    min.add(Math.min(min.get(min.size()-1),x));
    else
      min.add(x);
  }

  public void pop() {
    if(arr.size()!=0)
    {
      arr.remove(arr.size()-1);
      min.remove(min.size()-1);
    }
  }

  public int top() {
    return arr.get(arr.size()-1);
  }

  public int getMin() {
    if(min.size()!=0)
    return min.get(min.size()-1);
    return 0;
  }


  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-1);
    minStack.top();
    minStack.getMin();
    minStack.pop();
    minStack.pop();
    minStack.pop();
    minStack.pop();
    minStack.push(-2);
    minStack.push(10);
    minStack.push(-6);
    minStack.pop();
    minStack.getMin();
    minStack.pop();
    minStack.pop();
  }

}


