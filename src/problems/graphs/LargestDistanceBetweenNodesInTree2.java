package problems.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class LargestDistanceBetweenNodesInTree2 {

  public static void main(String[] args) {
    System.out.println(new LargestDistanceBetweenNodesInTree2()
        .solve(new int[]{-1, 0, 0, 0, 1, 1, 1, 4, 5, 7, 3}));
  }

  public int solve(int[] A) {
    int N = A.length;
    int max = 0;
    Map<Integer,ArrayList<Integer>> map= new HashMap<>();

    ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    for(int i=0;i<N;i++)
      tree.add(new ArrayList<>());

    for (int i =1 ; i < N; i++) {
      ArrayList<Integer> nodes= tree.get(A[i]);
      nodes.add(i);
      tree.set(A[i], nodes);

      nodes=tree.get(i);
      nodes.add(A[i]);
      tree.set(i,nodes);

    }

    //find the farthest node using BFS
    int node = bfs(tree);

    //Find largest distant node from farthest node using dfs

    return dfs(tree,node);

  }

  int dfs(ArrayList<ArrayList<Integer>> tree,int node) {
    int max = 0;
    Stack<Node> stack = new Stack<>();
    stack.push(new Node(node,0));

    boolean visited[]= new boolean[tree.size()];
    visited[node]=true;
    while(!stack.isEmpty())
    {
      Node ele= stack.pop();
      int count=ele.depth;
      max=Math.max(max,count);
      Iterator<Integer> itr = tree.get(ele.value).iterator();
      while (itr.hasNext()) {
        int v = itr.next();
        if(!visited[v])
        {
          visited[v]=true;
          stack.push(new Node(v,count+1));
        }

      }
    }

    return max;

  }

  class Node{
    int value;
    int depth;
    Node(int v,int d)
    {
      this.value=v;
      this.depth=d;
    }
  }

  // Last node in BFS queue will be the farthest node from root
  int bfs(ArrayList<ArrayList<Integer>> tree) {
    boolean visited[]= new boolean[tree.size()];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    visited[0]=true;
    int node = -1;
    while (!queue.isEmpty()) {
      node = queue.poll();
      Iterator<Integer> itr = tree.get(node).iterator();
      while (itr.hasNext()) {
        int ele = itr.next();
        if(!visited[ele])
        {
          visited[ele]=true;
          queue.add(ele);
        }
      }
    }

    return node;
  }
}
