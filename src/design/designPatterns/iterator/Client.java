package designPatterns.iterator;

/**
 * Spammer
 */
public class Client {

  public SocialNetwork socialNetwork;
  public ProfileIterator iterator;

  public Client(SocialNetwork facebook) {
    this.socialNetwork = facebook;
  }

  void sendSpam() {
    this.iterator = this.socialNetwork.createFbIterator("customer");
    while (iterator.hasNext()) {
      send(iterator.next());
    }
  }

  void sendDiffSpam() {
    this.iterator = this.socialNetwork.createFbEmployeeIterator("employee");
    while (iterator.hasNext()) {
      send(iterator.next());
    }
  }

  void send(String a) {

  }
}
