package problems.contests.codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BoatsCompetition {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    solution(in, out);
    in.close();
    out.close();
  }

  public static void solution(Scanner in, PrintWriter out) {
    //type = 0 (number of test cases known), 1 (only 1 test case), 2 (number of test cases unknown)
    int T = 0, type = 0;
    if (type == 0) {
      T = Integer.parseInt(in.nextLine());
    } else if (type == 1) {
      T = 1;
    }
    for (int t = 0; t < T; t++) {
      algo(in, out);
    }
  }

  public static void algo(Scanner in, PrintWriter out) {
    int N = in.nextInt();
    int[] A = new int[N];
    int count=0;
    for (int i = 0; i < N; i++) {
      A[i] = in.nextInt();
    }
   List<Integer> sumList= new ArrayList<>();

    for(int i=0;i<N;i++)
    {
      for(int j=i+1;j<N;j++)
      {
        sumList.add(A[i]+A[j]);
      }

    }

    int maxCount=0;

    for(int j=0;j<sumList.size();j++) {
      HashMap<Integer,Integer> map = new HashMap<>();
      int sum = sumList.get(j);
      count=0;
      for (int i = 0; i < N; i++) {
          if (map.get(A[i]) != null) {
            count++;
            map.put(sum, map.get(A[i]) - 1);
            if (map.get(A[i]) == 0)
              map.remove(A[i]);
          } else
            map.put(sum - A[i], 1);

      }
      maxCount=Math.max(count,maxCount);
    }



    out.println(maxCount);
  }

}
