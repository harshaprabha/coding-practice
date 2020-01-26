package problems.trees;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

  Map<Character,TrieNode> pointer;
  boolean endOfword;

  public TrieNode()
  {
    pointer= new HashMap<>();
    this.endOfword=false;
  }

}
