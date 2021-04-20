package lld.bookmyshow.domain;

import java.util.Date;
import java.util.List;

public class ShowTime {
  private long id;
  private Hall hall;
  private Movie movie;
  private Date startTime;
  private Date endTime;
  private List<Seat> seats;

  public ShowTime(long id, Hall hall, Movie movie, Date startTime, Date endTime) {
    this.id = id;
    this.hall = hall;
    this.movie = movie;
    this.startTime = startTime;
    this.endTime = endTime;
  }
}
