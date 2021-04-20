package lld.bookmyshow.domain;

public class Seat {

  private int id;
  SeatStatus status;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public SeatStatus getStatus() {
    return status;
  }

  public void setStatus(SeatStatus status) {
    this.status = status;
  }

  public Seat(int id, SeatStatus status){
    this.id=id;
    this.status=status;
  }


}
