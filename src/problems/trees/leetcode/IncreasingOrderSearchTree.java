package problems.trees.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import problems.trees.leetcode.RangeSumOfBST.TreeNode;

public class IncreasingOrderSearchTree {
  class MemoObj{
    int i;
    int buy;
    int profit;
    MemoObj(int i,int buy, int profit){
      this.i=i;
      this.buy=buy;
      this.profit=profit;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      MemoObj memoObj = (MemoObj) o;
      return i == memoObj.i &&
          buy == memoObj.buy &&
          profit == memoObj.profit;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, buy, profit);
    }
  }


  public static void main(String[] args) {
    RangeSumOfBST.TreeNode root = new RangeSumOfBST.TreeNode(12);
    root.left = new RangeSumOfBST.TreeNode(10);
    root.left.left = new RangeSumOfBST.TreeNode(7);
    root.left.right = new RangeSumOfBST.TreeNode(11);
    root.right = new RangeSumOfBST.TreeNode(16);
    root.right.left = new RangeSumOfBST.TreeNode(15);
    root.right.right = new RangeSumOfBST.TreeNode(29);



    Map<Integer,Map<Integer, Map<Integer,Integer>>> hmap= new HashMap<>();
    if (hmap.get(0).get(-1).get(90)!=null){

    }

      Map<Integer,Integer> map3= new HashMap<>();
      map3.put(3,0);
     Map<Integer,Map<Integer,Integer>> map2= new HashMap<>();
      map2.put(2,map3);

      hmap.put(1,map2);


    System.out.println(new IncreasingOrderSearchTree().increasingBST(root));
    return;
  }

  public TreeNode increasingBST(TreeNode root) {

    if(root==null)
      return root;

    TreeNode tree= null;
    inorder(root,tree);
    return tree;
  }

  void inorder(TreeNode root,TreeNode tree){

    if(root==null)
      return;

    inorder(root.left,tree);
    TreeNode newNode=new TreeNode(root.val);
    if(tree==null)
      tree= newNode;
    else
    {
      tree.right=newNode;
      tree=tree.right;
    }
    inorder(root.right,tree);

  }

}
