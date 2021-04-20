package lld.bookmyshow.domain;


public class Booking {

  private long id;
  private User uid;
  private ShowTime sid;

  public Booking(long id, User uid, ShowTime sid) {
    this.id = id;
    this.uid = uid;
    this.sid = sid;
  }
}
