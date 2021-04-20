package lld;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  DoubleNode start;
  DoubleNode end;
  int count = 0;

  class DoubleNode {

    int key;
    int val;
    DoubleNode prev;
    DoubleNode next;

    DoubleNode(int k, int v) {
      this.key = k;
      this.val = v;
    }
  }


  int C;
  Map<Integer, DoubleNode> map;

  public LRUCache(int capacity) {
    start = null;
    end = null;
    this.C = capacity;
    map = new HashMap<>();
    count = 0;
  }

  public int get(int key) {

    if (!map.containsKey(key)) {
      return -1;
    }

    DoubleNode delNode = map.get(key);
    removeNode(delNode);
    addFirst(delNode);
    return map.get(key).val;

  }

  public void put(int key, int value) {
    // New key
    if (!map.containsKey(key)) {
      checkAndAdjustCapacity();
      DoubleNode newNode = new DoubleNode(key, value);
      addFirst(newNode);
      count++;
      map.put(key, newNode);
    } else {
      // upd value
      DoubleNode node = map.get(key);
      removeNode(node);
      addFirst(node);
    }

  }


  void checkAndAdjustCapacity() {

    if (count == C) {
      // remove last node
      int k = end.key;
      removeNode(end);
      // remove from map
      delMap(k);
      count--;
    }
  }

  void removeNode(DoubleNode node) {
    DoubleNode prev = node.prev;

    if (prev != null) {
      prev.next = node.next;
    }

    if (node.next != null) {
      node.next.prev = prev;
    }

    if (node == end) {
      end = prev;
    }
    if (node == start) {
      start = prev;
    }

    node.prev = null;
    node.next = null;
  }

  void delMap(int key) {
    map.remove(key);
  }


  void addFirst(DoubleNode node) {

    DoubleNode newNode = node;
    if (start == null) {
      start = newNode;
      end = start;
      return;
    }

    newNode.next = start;
    start.prev = newNode;
    start = newNode;

  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println(lruCache.get(1));
    lruCache.put(3, 3);
    System.out.println(lruCache.get(2));
    lruCache.put(4, 4);
    System.out.println(lruCache.get(1));
    System.out.println(lruCache.get(3));
    System.out.println(lruCache.get(4));

  }


}


