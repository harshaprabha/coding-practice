package problems.trees;

public class TrieOperations {

  public static void main(String[] args) {
    Trie trie = new Trie();
    TrieNode node = new TrieNode();
    String[] words = {"cat", "comb", "ate"};
    for (String word : words
    ) {
      node = trie.insert(node, word, 0, word.length());
    }
    System.out.println(trie.isPresent(node, "cat", 0, 3));
    System.out.println(trie.isPresent(node, "ate", 0, 3));
    System.out.println(trie.isPresent(node, "cata", 0, 4));


  }

}
