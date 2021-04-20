package designPatterns.iterator;

public interface SocialNetwork {

  FBIterator createFbIterator(String name);

  FBIterator createFbEmployeeIterator(String name);


}
