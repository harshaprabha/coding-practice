package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RedundantConnection2 {

  public static void main(String[] args) {
    int[][] edges= {{1,2},{1,3},{2,3}};

    int[] res= new RedundantConnection2().findRedundantDirectedConnection(edges);
    System.out.println(res[0]+" "+res[1]);

  }

  int[] visited;
  List<int[]> backEdges;
  List<int[]> forwardEdges;
  public int[] findRedundantDirectedConnection(int[][] edges) {
    int n= edges.length;
    LinkedList<Integer>[] adjList= new LinkedList[n+1];
    backEdges= new ArrayList<>();
    forwardEdges= new ArrayList<>();

    int parent[]= new int[n+1];
    visited= new int[n+1];
    int[] doubleParent= new int[2];
    int child=-1;

    for(int i=0;i<=n;i++)
      adjList[i]= new LinkedList<>();

    // construct graph
    for(int i=0;i<n;i++)
    {
      if(parent[edges[i][1]]!=0)
      {
        doubleParent[0]= parent[edges[i][1]];
        doubleParent[1]=edges[i][0];
        child=edges[i][1];
      }
      else
        parent[edges[i][1]]=edges[i][0];

      adjList[edges[i][0]].add(edges[i][1]);
    }

    int root=-1;
    for(int j=1;j<n+1;j++)
    {
      if(parent[j]==0)
      {
        root=j;
        break;
      }
    }

    // Rooted => check for doubleparent
    if(root!=-1)
    {
      boolean cyclePresent=dfs(root,adjList);
      if(cyclePresent)
        return backEdges.get(0); // only one backedge, so remove that

      // remove one of the double parent edges to child which comes last
      // One TreeEdge and other forward edge
      for(int i=n-1;i>=0;i--){
        int[] edge=edges[i];
        for(int k=0;k<2;k++){
          //if either of double edge is equal to edge input, return that
          if(edge[0]==doubleParent[k] && edge[1]==child)
            return new int[]{edge[0],edge[1]};
        }

      }//for



    }//if


    // No root, so find all edges in cycle
    backEdges= new ArrayList<>();

    for(int i=1;i<=n;i++)
    {
      Arrays.fill(visited,0);
      dfs(i,adjList);
    }


    for(int i=n-1;i>=0;i--){
      int[] edge=edges[i];
      for(int k=0;k<backEdges.size();k++){
        //if either of double edge is equal to edge input, return that
        if(edge[0]==backEdges.get(k)[0] && edge[1]==backEdges.get(k)[1])
          return new int[]{edge[0],edge[1]};
      }

    }//for


    return new int[]{0,0};

  }


  boolean dfs(int root, LinkedList<Integer>[] adjList){

    visited[root]=1;
    for(int vertex:adjList[root])
    {
      if(visited[vertex]==1) {
        backEdges.add(new int[]{root, vertex});
        return true;
      }

      if(dfs(vertex,adjList))
        return true;

    }
    visited[root]=2;
    return false;

  }



}
