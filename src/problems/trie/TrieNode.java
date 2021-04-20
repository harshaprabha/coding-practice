package problems.trie;

public class TrieNode {

  private TrieNode[] links;
  private boolean isEnd;
  private final int N = 26; // alphabet count
  private int freq;

  public TrieNode() {
    this.links = new TrieNode[N];
    this.freq=0;
  }

  public boolean containsKey(char ch) {
    return links[ch - 'a'] != null;
  }

  public TrieNode get(char ch) {
    return links[ch - 'a'];
  }

  public void put(char ch, TrieNode node) {
    links[ch - 'a'] = node;
  }

  public boolean isEnd() {
    return isEnd;
  }

  public void setEnd(boolean end) {
    isEnd = end;
  }

  public void setFreq(int freq) {
    this.freq = freq;
  }

  public int getFreq() {
    return freq;
  }
}
