package problems.graphs;

/**
 * If m operations, either Union or Find, are applied to n elements, the total run time is O(m
 * log*n)
 */
public class UnionFind {

  int[] parent; // parent/representation of set
  int[] componentSize; // size of each component
  int size;// Size of Union find
  int noOfComponents; // total no of components

  public UnionFind(int size) {
    this.size = size;
    parent = new int[size];
    componentSize = new int[size];
    this.noOfComponents = size;

    for (int i = 0; i < size; i++) {
      parent[i] = i;  // Every component is parent/rep of itself
      componentSize[i] = 1;
    }
  }

  /**
   * Return root/representative/parent of the component With path compression -> worst case is
   * O(logn) , best is O(1) https://www.youtube.com/watch?v=VHRhJWacxis
   */
  int find(int i) {

    int root = i;

    // Find parent
    while (root != parent[root]) //if root's parent is not itself
    {
      root = parent[root];
    }

    // Path Compression - Mark all nodes their parent/parent as root
    while (i != parent[i]) {
      int temp = parent[i];
      parent[i] = root;
      i = temp;
    }

    return root;
  }


  /**
   * O(logn) , best is O(1)
   */
  void union(int i, int j) {

    int rep1 = find(i);
    int rep2 = find(j);

    if (rep1 == rep2) {
      return;  // return if both belong to same component
    }

    if (componentSize[rep1]
        > componentSize[rep2]) {  // Merge smaller component into larger component to maintain a balanced tree
      //Merge i into j - make root of i parent of root of j
      parent[rep2] = rep1;
      componentSize[rep1] = componentSize[rep1] + componentSize[rep2];


    } else {
      //Make j's parent as i - Merge j into i
      parent[rep1] = rep2;
      componentSize[rep2] = componentSize[rep1] + componentSize[rep2];

    }
    noOfComponents--;

  }

  /**
   * Returns true if two items belong to same component
   */
  boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   * Returns size of component where element belongs to
   */
  public int componentSize(int i) {
    return componentSize[find(i)];
  }
}
