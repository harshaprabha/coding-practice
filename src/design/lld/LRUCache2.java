package lld;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2  extends LinkedHashMap<Integer,Integer> {

  int C;
  public LRUCache2(int capacity) {
    super(capacity);
    C=capacity;
  }

  public int get(int key) {
    return super.getOrDefault(key,-1);
  }

  public void put(int key, int value) {
    if(this.size()==C)
    super.put(key,value);

  }


}
