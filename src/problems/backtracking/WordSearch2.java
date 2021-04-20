package problems.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import java.util.List;
import problems.trie.TrieNode;

public class WordSearch2 {


  public static void main(String[] args) {
    Deque<Character> buffer;

    buffer= new ArrayDeque<>();

    char[][] board = {
        {'a', 'b'}};
    String[] words = {"a", "b"};
    new WordSearch2().findWords(board, words);
    System.out.println(result);
  }

  static List<String> result = new ArrayList<>();
  TrieNode root;

  WordSearch2() {
    root = new TrieNode();
  }

  void insertintoTrie(String word) {
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

  public List<String> findWords(char[][] board, String[] words) {

    if (board.length == 0 || words.length == 0) {
      return result;
    }

    // Insert into trie
    for (String word : words) {
      insertintoTrie(word);
    }

    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        TrieNode curr = root;
        backtrack(i, j, board, curr.get(board[i][j]), visited, "");
        visited[i][j] = false;
      }
    }

    return result;
  }

  void backtrack(int i, int j, char[][] board, TrieNode trieNode, boolean[][] visited,
      String word) {
    char ch = board[i][j];

    if (trieNode==null) // word doesnt exist
      return;

    visited[i][j] = true;

    word += ch;
    if (trieNode.isEnd() && trieNode.getFreq() == 0) {
      trieNode.setFreq(1);
      result.add(word);
    }

    trieNode = trieNode.get(ch);

    int X[] = {0, 1, -1, 0};
    int Y[] = {1, 0, 0, -1};

    for (int k = 0; k < 4; k++) {
      int x = X[k] + i;
      int y = Y[k] + j;

      if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && !visited[x][y]) {
        backtrack(x, y, board, trieNode, visited, word);
      }
    }

    word += word.substring(0, word.length() - 1);
    visited[i][j] = false;
  }

}
