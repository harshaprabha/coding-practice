package problems.trees;

public class BSTRecursive {

  Node root;

  public BSTRecursive() {
    this.root = null;
  }


  Node insert(Node root, int n) {
    if (root == null) {
      Node newNode = new Node(n);
      root = newNode;
      return root;
    }

    if (n <= root.value) {
      root.left = insert(root.left, n);
    } else {
      root.right = insert(root.right, n);
    }

    return root;

  }


  Node delete(Node root, int n) {

    if (root == null) {
      return root;
    }
    if (n < root.value) {
      root.left = delete(root.left, n);
    } else if (n > root.value) {
      root.right = delete(root.right, n);
    } else {
      // delete root
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        // two children
        Node inorder = getInorderSuccessor(root);
        root.value = inorder.value;
        root.right = delete(root.right, inorder.value);

      }
    }
    return root;

  }


  public Node getInorderSuccessor(Node root) {
    Node rightSubTree = root.right;

    while (rightSubTree.left != null) {
      rightSubTree = rightSubTree.left;
    }

    return rightSubTree;

  }

}
