package problems;

public class SegmentTree {

  private static int[] tree;
  int N;

  SegmentTree(int N) {
    this.N = N;
    // Allocate memory for segment tree
    //Height of segment tree
    int height = (int) (Math.ceil(Math.log(N) / Math.log(2)));

    //Maximum size of segment tree
    int max_size = 2 * (int) Math.pow(2, height) - 1;
    tree = new int[max_size]; // Total nodes = 2 * N - 1, but we need to accomodate spaces for the empty last row if any
  }

  // O(N) time and space
  public int buildTree(int index, int left, int right, int[] A) {
    if (left == right) // leaf node
    {
      tree[index] = A[left];
      return A[left];
    }

    int mid = (left + right) / 2;
    tree[index] =
        buildTree(2 * index + 1, left, mid, A) + buildTree(2 * index + 2, mid + 1, right, A);
    return tree[index];

  }

  void updateTree(int treeIndex, int treeLeft, int treeRight, int[] A, int updIndexLeft,
      int updIndexRight, int diff) {

    if (updIndexLeft < treeLeft || updIndexRight > treeRight) // no overlap
    {
      return;
    }

    tree[treeIndex] += diff;// As long as its in rage it will get updated for both - partial and complete overlap
    if (treeLeft == treeRight) {
      return;  // return if its leaf node
    }

    int mid = (treeLeft + treeRight) / 2;
    updateTree(2 * treeIndex + 1, treeLeft, mid, A, updIndexLeft, updIndexRight, diff);
    updateTree(2 * treeIndex + 2, mid + 1, treeRight, A, updIndexLeft, updIndexRight, diff);
  }


  int getRangeSum(int treeIndex, int treeLeft, int treeRight, int left, int right, int[] A) {

    // case 1 - complete overlap
    if (treeLeft >= left && treeRight <= right) {
      return tree[treeIndex];
    }

    // case 2 - no overlap
    if (left > treeRight || right < treeLeft) {
      return 0;
    }

    // case 3 - partial overlap
    int mid = (treeLeft + treeRight) / 2;

    return getRangeSum(2 * treeIndex + 1, treeLeft, mid, left, right, A) + getRangeSum(
        2 * treeIndex + 2, mid + 1, treeRight, left, right, A);

  }

  public static void main(String[] args) {
    int A[] = {1, 3, 5, 7, 9, 11};
    SegmentTree segTree = new SegmentTree(A.length);
    segTree.buildTree(0, 0, A.length - 1, A);
    for (int i = 0; i < tree.length; i++) {
      // System.out.println(tree[i]);
    }

    System.out.println(segTree.getRangeSum(0, 0, A.length - 1, 1, 5, A));

  }


}
