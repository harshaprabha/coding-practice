package problems.trees;

public class PathSum {

  public static void main(String[] args) {
    Node A = new Node(1000);
    A.left = new Node(2000);
    A.left.left = new Node(-3001);

    System.out.println(new PathSum().hasPathSum(A, -1));
  }

  public int hasPathSum(Node A, int B) {
    return pathSum(A, 0, B);

  }

  public int pathSum(Node A, int sum, int S) {
    if(A ==null)
      return 0;

    if(A.left==null && A.right==null && A.value==S)
      return 1;
    else
    {
      if(pathSum(A.left, sum, S-A.value)==1||pathSum(A.left, sum, S-A.value)==1)
        return 1;
      else return 0;
    }

  }

}
