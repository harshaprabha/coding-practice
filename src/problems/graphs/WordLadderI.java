package problems.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class WordLadderI {

  public static void main(String[] args) {

    String[] Cc={"hot", "dot", "dog", "lot", "log"} ;
    ArrayList<String> C= new ArrayList<>(Arrays.asList(Cc));
    System.out.println(new WordLadderI().solve("hit","cog",C));
  }
  class Graph{
    int V;
    int E;
    Map<String,LinkedList<String>> adjList;

    Graph(int v)
    {
      this.V=v;
      adjList= new HashMap<>();
    }

    void addEdge(String start, String end){
      LinkedList<String> ll;
      if(adjList.get(start)==null)
      {
        ll= new LinkedList<>();
        ll.add(end);
        adjList.put(start,ll);
      }
      else
      {
        ll= adjList.get(start);
        ll.add(end);
        adjList.put(start,ll);
      }
    }
  }

  public int solve(String A, String B, ArrayList<String> C) {

    int n= C.size();

    if(A.equals(B))
      return 0;

    int V= n+2;
    Graph graph = new Graph(V);

    C.add(A);
    C.add(B);

    for(String node: C){
      for(String str:C){
        if(node.equals(str))
          continue;
        if(isDiffOne(node,str))
          graph.addEdge(node,str);
      }
    }

    int hops= bfs(A,B,graph);
    return hops;
  }


  boolean isDiffOne(String A, String B){
    int diff=0;
    int n= A.length();
    for(int i=0;i<n;i++){
      if(A.charAt(i)!=B.charAt(i))
        diff++;

      if(diff>1)
        return false;

    }

    return true;

  }

  class Pair{
    String node;
    int hop;
    Pair(String n,int h){
      this.node=n;
      this.hop=h;
    }
  }

  int bfs(String start,String end,Graph graph){

    List<Integer> arr= new LinkedList<>();

    int hops=Integer.MAX_VALUE;
    Map<String,Boolean> visited= new HashMap<>();
    Queue<Pair> queue= new LinkedList<>();

    queue.add(new Pair(start,1));
    visited.put(start,true);

    while(!queue.isEmpty()){
      Pair ele= queue.remove();

      if(ele.node.equals(end))
        hops=Math.min(hops,ele.hop);

      for(String node: graph.adjList.get(ele.node)){

        if(visited.get(node)==null)
        {
          visited.put(node,true);
          queue.add(new Pair(node,ele.hop+1));
        }

      }


    }//while

    return hops;

  }


}
