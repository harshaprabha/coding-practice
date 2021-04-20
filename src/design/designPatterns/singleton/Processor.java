package designPatterns.singleton;

public class Processor {

  // Eager initialization
  // private Resource resource = new Resource();

  private Resource resource; // composition

  public Processor() {

  }

  // Same every Processor obj will contain a new resource object, still heavy
//  private Resource getResource() {
//    resource = new Resource();
//    return resource;
//  }

  /**
   * To reduce no of object footprint, i can reuse one object that gets created, but this is not
   * thread safe
   */
//  private Resource getResource() {
//    if (resource == null) {
//      resource = new Resource(); // Lazy loading
//    }
//    return resource;
//  }


  /**
   * Thread safe, but this is slow as all threads have to wait at synchronized block, what if they
   * can skip this
   */
//  private Resource getResource() {
//
//    synchronized (this) {
//      if (resource == null) {
//        resource = new Resource();
//      }
//    }
//
//    return resource;
//  }


  /**
   * Double locking
   *
   */
  private Resource getResource() {
      
    if (resource == null) {
      synchronized (this) {
        if (resource == null) {
          resource = new Resource();
        }
      }
    }

    return resource;
  }

}
