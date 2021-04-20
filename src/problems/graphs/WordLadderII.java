package problems.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordLadderII {


  static Map<String, Boolean> visited;
  static int min = Integer.MAX_VALUE;
  static List<List<String>> result;

  public static void main(String[] args) {
    List<String> wordList = new ArrayList<>(
        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

    new WordLadderII().findLadders("hit", "cog", wordList);
    System.out.println(result);
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    int n = wordList.size();
    visited = new HashMap<>();
    dfs(beginWord, endWord, wordList, new ArrayList<>());
    return result;

  }


  void dfs(String startWord, String endWord, List<String> wordList, List<String> transformedWords) {
    visited.put(startWord, true);
    transformedWords.add(startWord);

    if (startWord.equals(endWord)) {
      if (transformedWords.size() < min) {
        min = transformedWords.size();
        result = new ArrayList<>();
        result.add(new ArrayList<>(transformedWords));
      } else if (transformedWords.size() == min) {
        result.add(new ArrayList<>(transformedWords));
      }
      return;
    }//if

    for (int i = 0; i < wordList.size(); i++) {
      if (visited.get(wordList.get(i)) == null && isDiffByOneChar(startWord, wordList.get(i))) {
        dfs(wordList.get(i), endWord, wordList, transformedWords);
      }

    }//for

  }

  boolean isDiffByOneChar(String word1, String word2) {

    int n = word1.length();
    int i = 0;
    int c = 0;
    while (i < n) {
      if (word1.charAt(i) != word2.charAt(i)) {
        c++;
      }
      if (c > 1) {
        return false;
      }
      i++;
    }
    if(c==0)
      return false;

    return true;
  }


}
