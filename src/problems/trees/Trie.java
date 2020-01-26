package problems.trees;

public class Trie {

  public TrieNode insert(TrieNode root, String word, int i, int n) {

    if (i == n) {
      root.endOfword = true;
      return root;
    }

    if (!root.pointer.containsKey(word.charAt(i))) {
      root.pointer.put(word.charAt(i), insert(new TrieNode(), word, i + 1, n));
    } else {
      insert(root.pointer.get(word.charAt(i)), word, i + 1, n);
    }

    return root;

  }


  public boolean isPresent(TrieNode root, String word, int i, int n) {

    if (i == n && root.endOfword == true) {
      return true;
    }

    if (!root.pointer.containsKey(word.charAt(i))) {
      return false;
    }

    if (isPresent(root.pointer.get(word.charAt(i)), word, i + 1, n)) {
      return true;
    }

    return false;
  }


}
