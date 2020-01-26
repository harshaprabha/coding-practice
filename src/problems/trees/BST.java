package problems.trees;

public class BST {

  Node root;

  public BST() {
    this.root = null;
  }

  public void insert(int n) {

    Node newNode = new Node(n);
    //root element
    if (root == null) {
      root = newNode;
      return;
    }
    Node parent = root;
    Node curr = root;
    while (curr != null) {
      if (n <= curr.value) {
        parent = curr;
        curr = curr.left;
      } else {
        parent = curr;
        curr = curr.right;
      }
    }

    if (n <= parent.value) {
      parent.left = newNode;
    } else {
      parent.right = newNode;
    }

  }


  public void delete(int n) {
    //find the node and place parent pointer
    Node curr = root;
    Node parent = null;

    while (curr != null) {
      if (n < curr.value) {
        parent = curr;
        curr = curr.left;
      } else if (n > curr.value) {
        parent = curr;
        curr = curr.right;
      } else {
        break;
      }
    }

    // case 1:  leaf node
    if (curr.left == null && curr.right == null) {
      if (parent.left.value == n) {
        parent.left = null;
      } else {
        parent.right = null;
      }

    }
    //case 2: has one child
    else if ((curr.left != null && curr.right == null) || (curr.left == null
        && curr.right != null)) {
      boolean isRight = parent.right == curr ? true : false;

      //Make parent point to left/right of deleted node
      if (isRight) {
        parent.right = curr.left != null ? curr.left : curr.right;
      } else {
        parent.left = curr.left != null ? curr.left : curr.right;
      }

      // Remove pointers
      if (curr.left != null) {
        curr.left = null;
      } else {
        curr.right = null;
      }

    }
    //case 3: node has two children
    else {

      //Find inorder successor
      Node rightSubTree = curr.right;
      Node inorderSuccessorParent = null;

      while (rightSubTree.left != null) {
        inorderSuccessorParent = rightSubTree;
        rightSubTree = rightSubTree.left;
      }

      Node inorderSuccessor = rightSubTree;

      curr.value = inorderSuccessor.value;

      // delete inordersuccessor node
      // if leaf node
      if (inorderSuccessor.left == null && inorderSuccessor.right == null) {
        if (inorderSuccessorParent.left.value == inorderSuccessor.value) {
          inorderSuccessorParent.left = null;
        } else {
          inorderSuccessorParent.right = null;
        }

      }
      //one child
      else if ((inorderSuccessor.left != null && inorderSuccessor.right == null) || (
          inorderSuccessor.left == null
              && inorderSuccessor.right != null)) {
        boolean isRightSuccessor = inorderSuccessorParent.right == inorderSuccessor ? true : false;

        //Make parent point to left/right of deleted node
        if (isRightSuccessor) {
          inorderSuccessorParent.right =
              inorderSuccessor.right;
        } else {
          inorderSuccessorParent.left = inorderSuccessor.right;
        }

        // Remove pointers
        if (inorderSuccessor.left != null) {
          inorderSuccessor.left = null;
        } else {
          inorderSuccessor.right = null;
        }

      }


    }
  }

  public void traverse(Node root) {

    if (root == null) {
      return;
    }
    traverse(root.left);
    System.out.print(root.value + " ");
    traverse(root.right);

  }


}
