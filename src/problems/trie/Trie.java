package problems.trie;

import java.util.Arrays;
import java.util.List;

public class Trie {

  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public static void main(String[] args) {
    List<String> dict = Arrays.asList("pea", "peak");
    Trie trie = new Trie();
    for (String word : dict) {
      trie.insertInTrie(word);
    }

    trie.search("peak");
    trie.search("atii");


  }

  // O(M+N) to build trie
  void insertInTrie(String word) {
    TrieNode curr = root;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!curr.containsKey(ch)) {
        curr.put(ch, new TrieNode());
      }
      curr = curr.get(ch);
    }//for

    curr.setEnd(true);

  }

  void search(String word) {
    TrieNode curr = root;
    int i = 0;
    while (i < word.length()) {
      char ch = word.charAt(i);
      if (curr.get(ch) == null) {
        System.out.println("Word doesnt exist");
        return;
      }
      curr = curr.get(ch);
      i++;
    }

    if (curr.isEnd()) {
      System.out.println("Word present");
    } else {
      System.out.println("Prefix present");
    }

  }


}
