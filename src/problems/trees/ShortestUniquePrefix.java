package problems.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

  class TrieNode {

    Map<Character, TrieNode> pointer;
    boolean endOfWord;
    int freq;

    public TrieNode() {
      pointer = new HashMap<>();
      endOfWord = false;
      freq = 1;
    }

  }

  public static void main(String[] args) {
    System.out.println(new ShortestUniquePrefix()
        .prefix(new ArrayList<>(Arrays.asList("dog", "duck", "dove", "zebra"))));
  }


  ArrayList<String> result = new ArrayList<String>();

  public ArrayList<String> prefix(ArrayList<String> A) {

    TrieNode root = new TrieNode();
    //build Trie with the A
    for (int i = 0; i < A.size(); i++) {
      root = buildTrie(A.get(i), root, 0, A.get(i).length());
    }

    //Search Trie for every word
    String prefix = "";
    for (int i = 0; i < A.size(); i++) {
      result.add(searchPrefix(A.get(i), root));
    }

    return result;

  }

  public String searchPrefix(String str, TrieNode root) {
    int n = str.length();
    String prefix = "";

    for (int i = 0; i < n; i++) {
      if (root.endOfWord != true) {
        if (root.pointer.containsKey(str.charAt(i))) {
          root = root.pointer.get(str.charAt(i));
          prefix += str.charAt(i);
          if (root.freq == 1) {
            return prefix;

          }


        }//if
      }

    }

    return prefix;

  }

  public TrieNode buildTrie(String inp, TrieNode root, int i, int n) {

    TrieNode start = root;
    while (i < n) {

      if (!root.pointer.containsKey(inp.charAt(i))) {
        TrieNode newNode = new TrieNode();
        if (i == n - 1) {
          newNode.endOfWord = true;
        }
        root.pointer.put(inp.charAt(i), newNode);
      } else {
        TrieNode next = root.pointer.get(inp.charAt(i));
        next.freq = next.freq + 1;
        root.pointer.put(inp.charAt(i), next);
      }

      root = root.pointer.get(inp.charAt(i));
      i++;
    }

    return start;

  }


}
