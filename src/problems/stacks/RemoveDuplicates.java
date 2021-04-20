package problems.stacks;

import java.util.Stack;

public class RemoveDuplicates {

  public static void main(String[] args) {

    System.out.println(new RemoveDuplicates().removeDuplicates("deeedbbcccbdaa", 2));
  }

  public String removeDuplicates(String s, int k) {

    int n=s.length();
    int[] count= new int[26];

    Stack<Character> stack= new Stack<>();
    char[] buffer= new char[k];

    StringBuilder sb= new StringBuilder();

    for(int i=0;i<n;i++)
    {
      char ch=s.charAt(i);
      stack.push(ch);
      count[ch-'a']++;

      if(count[ch-'a']==k)
      {
        int loop=k-1;
        boolean isValid=true;

        while(loop>=0)
        {
          if(stack.peek()==ch)
            buffer[loop]=stack.pop();
          else
          {
            isValid=false;
            break;
          }
          loop=loop-1;
        }

        if(!isValid)
        {
          for(int j=loop+1;j<k;j++)
            stack.push(buffer[j]);
        }//if
        else
          count[ch-'a']=0;

      }//if

    }

    for(Character c:stack)
      sb.append(c);

    return sb.toString();

  }

}
