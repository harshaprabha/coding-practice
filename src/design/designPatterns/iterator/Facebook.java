package designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Facebook implements SocialNetwork{

  List<String> profiles;

  public Facebook(ProfileIterator iterator) {
    profiles = new ArrayList<>();
  }

  @Override
  public FBIterator createFbIterator(String name) {
    return new FBIterator(name);
  }

  @Override
  public FBIterator createFbEmployeeIterator(String name) {
    return new FBIterator(name);
  }
}
