package problems.graphs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule {

  public static void main(String[] args) {
    int[][] prerequisites = {{0, 2}, {1, 2}, {2, 0}};
    System.out.println(new CourseSchedule().findOrder2(3, prerequisites));
  }

  int state[];  //Undiscovered=0, Discovered=1, processed=2
  Stack<Integer> stack = new Stack<Integer>();

  // TS using DFS+stack    - O(V+E)
  public int[] findOrder2(int numCourses, int[][] prerequisites) {

    int[] result = new int[numCourses];
    LinkedList<Integer> adjList[] = new LinkedList[numCourses];

    int[] indegree = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      adjList[i] = new LinkedList<>();
    }

    for (int k = 0; k < prerequisites.length; k++) {
      adjList[prerequisites[k][0]].add(prerequisites[k][1]);
      indegree[prerequisites[k][1]] = indegree[prerequisites[k][1]] + 1;
    }

    int start = -1;
    for (int p = 0; p < numCourses; p++) {
      if (indegree[p] == 0) {
        start = p;
        break;
      }

    }

    if (start == -1) // cycle is present
    {
      return new int[]{};
    }

    state = new int[numCourses];// 1-discovered ,2-processed

    state[start] = 1;
    if (!doDfs(adjList, start)) {
      return new int[]{};
    }

    // Cover all components
    for (int l = 0; l < numCourses; l++) {
      if (state[l] != 2) // as long as vertex is not processed
      {
        state[l] = 1;
        doDfs(adjList, l);
      }
    }

    for (int l = 0; l < numCourses; l++) {
      if (state[l] != 2) {
        return new int[]{};
      }
    }

    int v = numCourses - 1;
    while (!stack.isEmpty()) {
      result[v--] = stack.pop();
    }

    return result;


  }


  boolean doDfs(LinkedList<Integer> adjList[], int start) {

    for (Integer adjVertex : adjList[start]) {
      if (state[adjVertex] == 1)  // if discovered
      {
        return false;
      }
      if (state[adjVertex] == 0) {
        state[adjVertex] = 1;
        if (!doDfs(adjList, adjVertex)) {
          return false;
        }
      }

    }

    state[start] = 2;
    stack.push(start);
    return true;
  }


  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] result = new int[numCourses];
    LinkedList<Integer> adjList[] = new LinkedList[numCourses];

    int[] indegree = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      adjList[i] = new LinkedList<>();
    }

    for (int k = 0; k < prerequisites.length; k++) {
      adjList[prerequisites[k][0]].add(prerequisites[k][1]);
      indegree[prerequisites[k][1]] = indegree[prerequisites[k][1]] + 1;
    }

    // start with vertex with indegree 0

    Queue<Integer> queue = new LinkedList<>();
    int r = numCourses - 1;
    boolean visited[] = new boolean[numCourses];

    for (int p = 0; p < numCourses; p++) {
      if (indegree[p] == 0 && !visited[p]) {
        visited[p] = true;
        queue.add(p);
      }
    }

    while (!queue.isEmpty()) {

      Integer vertex = queue.remove();
      result[r--] = vertex;
      indegree[vertex] = -1;
      for (Integer vert : adjList[vertex]) {
        indegree[vert] = indegree[vert] - 1;
        if (indegree[vert] == 0) {
          queue.add(vert);
        }
      }

    }

    if (r >= 0) {
      return new int[]{};
    }

    return result;


  }


  public boolean canFinish(int numCourses, int[][] prerequisites) {

    if (prerequisites.length == 0 || numCourses == 0) // No constraints
    {
      return true; // Possible ways to topological sort(total linear ordering) is n!
    }

    int V = numCourses;

    LinkedList<Integer> adjList[] = new LinkedList[V];
    state = new int[V];

    for (int i = 0; i < V; i++) {
      adjList[i] = new LinkedList<>();
    }

    //Build adjList - O(E)
    for (int j = 0; j < prerequisites.length; j++) {
      int src = prerequisites[j][0];
      int dest = prerequisites[j][1];
      adjList[src].add(dest);

    }
    int start = 0;

    //Check cycle for all vertices with indegree = 0 as we can have multiple components in this graph

    for (int k = 0; k < V; k++) {
      start = k;
      //Undiscovered=0, Discovered=1, processed=2
      if (state[start] == 0) {
        state[start] = 1;
        if (detectCycle(start, adjList)) {
          return false;
        }
      }
    }

    return true;

  }

  boolean detectCycle(int vertex, LinkedList<Integer> adjList[]) {

    for (Integer adjVertex : adjList[vertex]) {

      if (state[adjVertex] == 1 && state[adjVertex] != 2) { // found back edge creating cycle
        return true;
      }

      if (state[adjVertex] == 0) {
        state[adjVertex] = 1;
        if (detectCycle(adjVertex, adjList)) {
          return true;
        }
      }

    }

    state[vertex] = 2;
    return false;

  }


}
