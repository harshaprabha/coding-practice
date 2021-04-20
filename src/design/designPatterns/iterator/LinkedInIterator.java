package designPatterns.iterator;

public class LinkedInIterator implements ProfileIterator {

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public String next() {
    return null;
  }
}
