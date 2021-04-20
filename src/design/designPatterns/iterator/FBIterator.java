package designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class FBIterator implements ProfileIterator {

  String name;
  List<String> profiles;
  int currPos;

  public FBIterator(String name) {
    this.name=name;
    profiles = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      profiles.add(i + "profile");
    }
  }

  @Override
  public boolean hasNext() {
    return currPos < profiles.size();
  }

  @Override
  public String next() {
    String res = null;
    if (hasNext()) {
      res = profiles.get(currPos);
    }
    currPos++;
    return res;
  }

}
