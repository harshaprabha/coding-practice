package problems.trees;

public class BSTBasicOperations {

  public static void main(String[] args) {
    BST bst= new BST();

    bst.insert(10);
    bst.insert(20);
    bst.insert(19);
    bst.insert(7);
    bst.insert(30);
    bst.insert(21);
    bst.insert(35);
    bst.insert(40);
    bst.insert(34);
    bst.insert(32);
    bst.insert(33);

    bst.traverse(bst.root);
    bst.delete(30);
    bst.traverse(bst.root);


  }

}
